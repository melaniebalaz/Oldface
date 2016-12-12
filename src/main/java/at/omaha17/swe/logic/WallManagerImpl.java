package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.*;

import java.io.IOException;
import java.util.Vector;

public class WallManagerImpl implements WallManager {

    private MessageDAO messageDAO;
    private UserDAO userDAO;

    public WallManagerImpl() {
        this.messageDAO = new MessageDAOSerialization("MessageDB.ser");
        this.userDAO = new UserDAOSerialization("UserDB.ser");
    }

    public Vector<Post> getPosts(Wall wall) throws WallException {
        try {
            return messageDAO.getPostsByUsername(wall.getUser().getUsername());
        } catch (IOException|ClassNotFoundException e) { throw new WallException(e); }
    }

    public void addPost(Wall wall, Senior author, String content) throws WallException {
        Message message = new Post(wall, author, content);
        try {
            messageDAO.saveMessage(message);
        } catch (IOException|ClassNotFoundException e) { throw new WallException(e); }
    }

    public void addComment(String postId, String authorUsername, String content) throws WallException {
        try {
            Message comment = new Comment(messageDAO.getPostById(postId), (Senior) userDAO.getUserByUsername(authorUsername), content);
            messageDAO.saveMessage(comment);
        } catch (IOException|ClassNotFoundException e) { throw new WallException(e); }
    }

    public Vector<Post> getDashboard(String username) throws WallException {
        try {
        	return messageDAO.getPostList(); // Iteration 1 : All Posts, the relation friendship is not implemented yet
        } catch (IOException|ClassNotFoundException e) { throw new WallException(e);}
    }
}
