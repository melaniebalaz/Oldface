package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.model.*;

import java.io.IOException;
import java.util.Vector;

public class WallManagerImpl implements WallManager {

    private MessageDAO messageDAO;

    public WallManagerImpl() {
        this.messageDAO = new MessageDAOSerialization("MessageDB.ser");
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

    public void addComment(Post post, Senior author, String content) throws WallException {
        Message message = new Comment(post, author, content);
        try {
            messageDAO.saveMessage(message);
        } catch (IOException|ClassNotFoundException e) { throw new WallException(e); }
    }

    public Vector<Message> getDashboard(String username) throws WallException {
        return null;
    }
}
