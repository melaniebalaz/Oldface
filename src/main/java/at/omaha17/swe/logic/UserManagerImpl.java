package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.User;

import java.io.IOException;

public class UserManagerImpl implements UserManager {

    private UserDAO userDAO;

    public UserManagerImpl(){
        this.userDAO = new UserDAOSerialization("UserDB.ser");
    }

    public User registerUser(String role, String username, String password) throws UserException {
        User user;

        try {
            if (userDAO.isUser(username))
                throw new UserException(UserException.ReasonCode.DUPLICATE_USER);

           if (role.equals(User.ROLE_SENIOR))
                user = new Senior(username, password);
            else
                user = new User(role, username, password);

            user.setLoginDate();
            userDAO.saveUser(user);
            return user;

        } catch (IOException|ClassNotFoundException e) { throw new UserException(e); }
    }

    public User authenticateUser(String username, String password) throws UserException {

        try {
            User user = userDAO.getUserByUsername(username);

            if (user == null)
                throw new UserException(UserException.ReasonCode.INVALID_USER);
            if (!user.getPassword().equals(password))
                throw new UserException(UserException.ReasonCode.INVALID_PASSWORD);

            user.setLoginDate();
            userDAO.saveUser(user);
            return user;

        } catch (IOException|ClassNotFoundException e) { throw new UserException(e); }

    }

    public User getUser(String username) throws UserException {
        try {
            User user = userDAO.getUserByUsername(username);
            if (user == null)
                throw new UserException(new NullPointerException("User not found"));
            return user;
        } catch (IOException|ClassNotFoundException e) { throw new UserException(e); }
    }

}
