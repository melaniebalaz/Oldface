package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.dao.UserNotFoundException;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.User;
import at.omaha17.swe.model.Wall;

public class UserManagerImpl implements UserManager {

    private UserDAO userDAO;
    private WallManager wallManager;

    public UserManagerImpl(){
        this.userDAO = new UserDAOSerialization("UserDB.ser");
        this.wallManager = new WallManagerImpl();
    }

    public User registerUser(String role, String username, String password) throws RegistrationFailedException {
        String passwordHash;
        User user;

        if (userDAO.isUser(username))
            throw new RegistrationFailedException(RegistrationFailedException.ReasonCode.EXISTING_USER);

        try { passwordHash = PasswordManager.createHash(password); }
        catch (PasswordManager.CannotPerformOperationException e) {
            throw new RegistrationFailedException(RegistrationFailedException.ReasonCode.UNKNOWN, e);
        }

        if (role.equals(User.ROLE_SENIOR)) {
            user = new Senior(username, passwordHash);
            Wall wall = new Wall(username);
            wallManager.saveWall(wall);
        }
        else
            user = new User(role, username, passwordHash);

        userDAO.saveUser(user);
        return user;
    }

    public User authenticateUser(String username, String password) throws AuthenticationFailedException {
        User user;

        try {
            user = userDAO.getUserByUsername(username);
            if (!PasswordManager.verifyPassword(password, user.getPassword()))
                throw new AuthenticationFailedException(AuthenticationFailedException.ReasonCode.INVALID_PASSWORD);

        } catch (UserNotFoundException e) {
            throw new AuthenticationFailedException(AuthenticationFailedException.ReasonCode.INVALID_USER);
        } catch (PasswordManager.CannotPerformOperationException|PasswordManager.InvalidHashException e) {
            throw new AuthenticationFailedException(AuthenticationFailedException.ReasonCode.UNKNOWN, e);
        }

        return user;
    }

    /**
     * Fetch the current user
     * @param authenticationToken Token by which to identify a user
     * @return a User identified by this token
     */
    public User getUser(String authenticationToken){
        return null;
    }

    public void getDashboard() { }
}
