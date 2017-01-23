package at.omaha17.swe.dao;

import java.io.IOException;
import java.util.Vector;
import at.omaha17.swe.model.Message;
import at.omaha17.swe.model.Post;

public interface MessageDAO {
    public void saveMessage(Message message) throws IOException, ClassNotFoundException;
    public void deleteMessage(Message message) throws IOException, ClassNotFoundException;
    public Message getMessageById(String messageId) throws IOException, ClassNotFoundException, IllegalArgumentException;
    public Vector<Post> getPostsByUsername(String username) throws IOException, ClassNotFoundException;
    public Vector<Post> getPostList() throws IOException, ClassNotFoundException;
    public Vector<Message> getMessageList() throws IOException, ClassNotFoundException;
}
