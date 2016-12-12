package at.omaha17.swe.dao;

import at.omaha17.swe.model.Message;
import at.omaha17.swe.model.Post;

import java.io.*;
import java.util.Vector;

public class MessageDAOSerialization implements MessageDAO {

    private File file;

    public MessageDAOSerialization(String filename) {
        file = new File(filename);
    }

    @SuppressWarnings("unchecked")
    public void saveMessage(Message message) throws IOException, ClassNotFoundException {
        Vector<Message> messageList;

        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            messageList = (Vector<Message>) objectInputStream.readObject();
            objectInputStream.close();
        } else
            messageList = new Vector<Message>();

        for (Message messageItem : messageList)
            if (messageItem.getMessageid().equals(message.getMessageid())) { messageList.remove(messageItem); break; }

        messageList.add(message);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(messageList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @SuppressWarnings("unchecked")
    public void deleteMessage(Message message) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<Message> messageList = (Vector<Message>) objectInputStream.readObject();
        objectInputStream.close();

        if (messageList.contains(message)) messageList.remove(message);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(messageList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @SuppressWarnings("unchecked")
    public Vector<Post> getPostsByUsername(String username) throws IOException, ClassNotFoundException {

        Vector<Post> postList = new Vector<Post>();
        if (!file.exists()) return null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<Message> messageList = (Vector<Message>) objectInputStream.readObject();
        objectInputStream.close();

        for (Message message : messageList)
            if (message instanceof Post && ((Post) message).getWall().equals(username))
                postList.add((Post) message);

        return postList;
    }

    @SuppressWarnings("unchecked")
    public Vector<Post> getPostList() throws IOException, ClassNotFoundException {

        Vector<Post> postList = new Vector<Post>();
        if (!file.exists()) return null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<Message> messageList = (Vector<Message>) objectInputStream.readObject();
        objectInputStream.close();

        for (Message message : messageList)
            if (message instanceof Post) postList.add((Post) message);

        return postList;
    }

    @SuppressWarnings("unchecked")
    public Post getPostById(String postId) throws IOException, ClassNotFoundException {

        if (!file.exists()) return null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<Message> messageList = (Vector<Message>) objectInputStream.readObject();
        objectInputStream.close();

        for (Message message : messageList)
            if ((message instanceof Post) && (message.getMessageid().equals(postId)))
                return (Post) message;

        return null;
    }
}
