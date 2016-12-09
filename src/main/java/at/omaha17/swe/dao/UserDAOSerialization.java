package at.omaha17.swe.dao;

import at.omaha17.swe.model.User;

import java.io.*;
import java.util.Vector;

public class UserDAOSerialization implements UserDAO {

    private File file;

    public UserDAOSerialization(String filename) {
        file = new File(filename);
    }

    @SuppressWarnings("unchecked")
    public void saveUser(User user) throws IOException, ClassNotFoundException {
        Vector<User> userList;

        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();
        } else
            userList = new Vector<User>();

        for (User userItem : userList)
            if (userItem.getUsername().equals(user.getUsername())) { userList.remove(userItem); break; }

        userList.add(user);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(userList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @SuppressWarnings("unchecked")
    public void deleteUser(User user) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<User> userList = (Vector<User>) objectInputStream.readObject();
        objectInputStream.close();

        if (userList.contains(user)) userList.remove(user);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(userList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @SuppressWarnings("unchecked")
    public User getUserByUsername(String username) throws IOException, ClassNotFoundException {

        if (!file.exists()) return null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<User> userList = (Vector<User>) objectInputStream.readObject();
        objectInputStream.close();

        for (User userItem : userList)
            if (userItem.getUsername().equals(username)) return userItem;

        return null;
    }

    @SuppressWarnings("unchecked")
    public Vector<User> getUserList() throws IOException, ClassNotFoundException {

        if (!file.exists()) return null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<User> userList = (Vector<User>) objectInputStream.readObject();
        objectInputStream.close();

        return userList;
    }

    @SuppressWarnings("unchecked")
    public boolean isUser(String username) throws IOException, ClassNotFoundException {

        if (!file.exists()) return false;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Vector<User> userList = (Vector<User>) objectInputStream.readObject();
        objectInputStream.close();

        for (User userItem : userList)
            if (userItem.getUsername().equals(username)) return true;

        return false;
    }

}