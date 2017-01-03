package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Follower;
import at.omaha17.swe.model.Senior;

import java.util.Vector;

public class ProfileManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");

    public static void blockProfile(String username) {

    }

    public static void updateProfile(Senior user) {

    }

    public static Senior findProfile(String username) {
        return null;
    }

    public static void followProfile(String username) {

    }

    public static Vector<Follower> getFollower() {
        return null;
    }
}
