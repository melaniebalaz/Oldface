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
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();

            for (User usr : userList)
                if (usr.getUsername().equals(user.getUsername())) userList.remove(usr);

            userList.add(user);

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
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

            for (User user : userList)
                if (user.getUsername().equals(username)) return user;

            throw new UserNotFoundException();

        } catch (IOException|ClassNotFoundException e) { e.printStackTrace(); }

        return null;
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

}