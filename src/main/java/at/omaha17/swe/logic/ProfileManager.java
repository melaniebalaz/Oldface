package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Senior;

import java.io.IOException;
import java.util.Vector;

public class ProfileManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");

    public static void blockProfile(String username) throws TechnicalException {

        try {
            Senior user = (Senior) userDAO.getUserByUsername(username);
            user.setStatus(Senior.SeniorStatus.BLOCKED);
            userDAO.saveUser(user);

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static void updateProfile(String username, String profileName, String profileAbstract) throws TechnicalException {

        try {
            Senior user = (Senior) userDAO.getUserByUsername(username);
            user.setDisplayName(profileName);
            user.setAbstract(profileAbstract);
            userDAO.saveUser(user);

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static Senior findProfile(String searchkey) {
        //not yet implemented - need info from UI
        return null;
    }

    public static void followProfile(String followerUsername, String followsUsername) throws TechnicalException {

        try {
            Senior follower = (Senior) userDAO.getUserByUsername(followerUsername);
            Senior follows = (Senior) userDAO.getUserByUsername(followsUsername);
            follower.addFollower(follows);
            userDAO.saveUser(follower);

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static Vector<Senior> getProfileFollower(String username) throws TechnicalException {

        try {
            return ((Senior) userDAO.getUserByUsername(username)).getFollowers();

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }
}
