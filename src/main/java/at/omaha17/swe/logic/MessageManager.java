package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Comment;
import at.omaha17.swe.model.Message;
import at.omaha17.swe.model.Post;
import at.omaha17.swe.model.Senior;

import java.io.IOException;

public class MessageManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");
    private static final MessageDAO messageDAO = new MessageDAOSerialization("MessageDB.ser");

    public static void addPost(String wallUsername, String authorUsername, String content) throws TechnicalException {
        try {
            Message message = new Post((Senior) userDAO.getUserByUsername(wallUsername), (Senior) userDAO.getUserByUsername(authorUsername), content);
            messageDAO.saveMessage(message);
        } catch (IOException |ClassNotFoundException e) { throw new TechnicalException(e); }
    }

    public static void addComment(String postId, String authorUsername, String content) throws TechnicalException {
        try {
            Post post = messageDAO.getPostById(postId);
            Comment comment = new Comment(post, (Senior) userDAO.getUserByUsername(authorUsername), content);
            post.addComment(comment);
            messageDAO.saveMessage(comment);
            messageDAO.saveMessage(post);
        } catch (IOException|ClassNotFoundException e) { throw new TechnicalException(e); }
    }

    public static void deleteMessage() {

    }

    public static void likeMessage() {

    }
}
