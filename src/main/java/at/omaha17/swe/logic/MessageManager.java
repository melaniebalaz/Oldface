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
            Message message = messageDAO.getMessageById(messageId);

            if (message instanceof Post)
                //delete all comments related with the given post
                for (Comment comment : ((Post) message).getComments())
                    messageDAO.deleteMessage(comment);

            if (message instanceof Comment) {
                //cleanup relation from post to comment
                Post post = ((Comment) message).getRelatedPost();
                post.delComment((Comment) message);
                messageDAO.saveMessage(post);
            }

            //finally delete the given message
            messageDAO.deleteMessage(messageDAO.getMessageById(messageId));

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static void likeMessage(String messageId, String username) throws TechnicalException {

        try {
            Message message = messageDAO.getMessageById(messageId);
            message.addLiker((Senior) userDAO.getUserByUsername(username));
            messageDAO.saveMessage(message);

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }
}
