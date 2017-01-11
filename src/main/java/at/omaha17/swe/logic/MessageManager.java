package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.*;

import java.io.IOException;

public class MessageManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");
    private static final MessageDAO messageDAO = new MessageDAOSerialization("MessageDB.ser");

    public static void addPost(String wallUsername, String authorUsername, String content) throws TechnicalException {
        try {
            Message message = new Post((Senior) userDAO.getUserByUsername(wallUsername), (Senior) userDAO.getUserByUsername(authorUsername), content);
            messageDAO.saveMessage(message);
        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static void addComment(String postId, String authorUsername, String content) throws TechnicalException {
        try {
            Post post = (Post) messageDAO.getMessageById(postId);
            Comment comment = new Comment(post, (Senior) userDAO.getUserByUsername(authorUsername), content);
            post.addComment(comment);
            messageDAO.saveMessage(comment);
            messageDAO.saveMessage(post);
        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static void deleteMessage(String messageId) throws TechnicalException {
        try {
            messageDAO.deleteMessage(messageDAO.getMessageById(messageId));
        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static void likeMessage(String username, String messageId) throws TechnicalException {
        try {
            Senior user = (Senior) userDAO.getUserByUsername(username);
            Message message = messageDAO.getMessageById(messageId);
            message.addLiker(user.getUsername());
            messageDAO.saveMessage(message);
        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }
}
