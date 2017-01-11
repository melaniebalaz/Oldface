package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.User;

import java.io.IOException;

public class AuthenticationManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");

    public static User registerUser(String role, String username, String password) throws AuthenticationException {

        try {
            if (userDAO.isUser(username))
                throw new AuthenticationException(AuthenticationException.ReasonCode.DUPLICATE_USER);

            User user;
            if (role.equals(User.ROLE_SENIOR))
                user = new Senior(username, password);
            else
                user = new User(role, username, password);

            user.setLoginDate();
            userDAO.saveUser(user);
            return user;

        } catch (IOException|ClassNotFoundException e) { throw new AuthenticationException(e); }
    }

    public static User loginUser(String username, String password) throws AuthenticationException {

        try {
            if (!userDAO.isUser(username))
                throw new AuthenticationException(AuthenticationException.ReasonCode.INVALID_USER);

            User user = userDAO.getUserByUsername(username);

            if (!user.getPassword().equals(password))
                throw new AuthenticationException(AuthenticationException.ReasonCode.INVALID_PASSWORD);

            user.setLoginDate();
            userDAO.saveUser(user);
            return user;

        } catch (IOException|ClassNotFoundException e) { throw new AuthenticationException(e); }
    }

}
