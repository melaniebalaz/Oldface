package at.omaha17.swe.dao;

import at.omaha17.swe.model.User;

import java.io.*;
import java.util.Vector;

public class UserDAOSerialization implements UserDAO {

    private String filename;

    public UserDAOSerialization(String filename) {
        this.filename = filename;
    }

    @SuppressWarnings("unchecked")
    public void saveUser(User user) {
        Vector<User> userList;
        File file;
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        try {
            file = new File(filename);
            if (file.exists()) {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                userList = (Vector<User>) objectInputStream.readObject();
                objectInputStream.close();
            } else
                userList = new Vector<User>();

            for (User userItem : userList)
                if (userItem.getUsername().equals(user.getUsername())) { userList.remove(userItem); break; }

            userList.add(user);

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(userList);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException|ClassNotFoundException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    public void deleteUser(User user) throws UserNotFoundException {
        Vector<User> userList;
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();

            if (userList.contains(user)) userList.remove(user);
            else throw new UserNotFoundException();

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
            objectOutputStream.writeObject(userList);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException|ClassNotFoundException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    public User getUserByUsername(String username) throws UserNotFoundException {
        Vector<User> userList;
        ObjectInputStream objectInputStream;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();

            for (User userItem : userList)
                if (userItem.getUsername().equals(username)) return userItem;

            throw new UserNotFoundException();

        } catch (IOException|ClassNotFoundException e) { e.printStackTrace(); return null; }

    }

    @SuppressWarnings("unchecked")
    public Vector<User> getUserList() {
        Vector<User> userList;
        ObjectInputStream objectInputStream;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (IOException|ClassNotFoundException e) { e.printStackTrace(); return null; }

        return userList;
    }

    @SuppressWarnings("unchecked")
    public boolean isUser(String username) {
        Vector<User> userList;
        ObjectInputStream objectInputStream;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();

            for (User userItem : userList)
                if (userItem.getUsername().equals(username)) return true;

        } catch (IOException|ClassNotFoundException e) { e.printStackTrace(); }

        return false;
    }

}