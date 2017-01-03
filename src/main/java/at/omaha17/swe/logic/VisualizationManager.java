package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Post;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.Wall;

import java.io.IOException;
import java.util.Vector;

public class VisualizationManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");
    private static final MessageDAO messageDAO = new MessageDAOSerialization("MessageDB.ser");

    public static Wall getWall(String username) throws TechnicalException {
        try {
            return new Wall((Senior) userDAO.getUserByUsername(username), messageDAO.getPostsByUsername(username));
        } catch (IOException|ClassNotFoundException e) { throw new TechnicalException(e); }
    }

    public static Vector<Post> getDashboard(String username) throws TechnicalException {
        try {
            return messageDAO.getPostList(); // Iteration 1 : All Posts, the relation friendship is not implemented yet
        } catch (IOException|ClassNotFoundException e) { throw new TechnicalException(e);}
    }

    public static void getStatistic() {

    }
}
