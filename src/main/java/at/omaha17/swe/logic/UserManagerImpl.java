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

    public User registerUser(String role, String username, String password) {
        String passwordHash;
        User user;

        //todo: check for existing username

        try {
            passwordHash = PasswordManager.createHash(password);
        } catch (PasswordManager.CannotPerformOperationException e) {
            e.printStackTrace(); return null;
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
        User user = null;

        try {
            user = userDAO.getUserByUsername(username);
            if (!PasswordManager.verifyPassword(password, user.getPassword()))
                throw new AuthenticationFailedException("Invalid password!");

        } catch (UserNotFoundException e) {
            throw new AuthenticationFailedException("Invalid username!");
        } catch (PasswordManager.CannotPerformOperationException e) {
            e.printStackTrace();
        } catch (PasswordManager.InvalidHashException e) {
            e.printStackTrace();
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
