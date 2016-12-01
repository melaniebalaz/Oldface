package at.omaha17.swe.dao;

import at.omaha17.swe.model.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public class UserDAOSerialization implements UserDAO {

    private String filename;

    public UserDAOSerialization(String filename) {
        this.filename = filename;
    }

    public void saveUser(User user) {

    }

    public void deleteUser(User user) throws UserNotFoundException {

    }

    @SuppressWarnings("unchecked")
    public User getUserByUsername(String username) throws UserNotFoundException {
        Vector<User> userList = null;
        ObjectInputStream objectInputStream;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            userList = (Vector<User>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found: User");
            e.printStackTrace();
        } catch (Exception e) { e.printStackTrace(); }

        for (User user : userList)
            if (user.getUsername().equals(username)) return user;

        throw new UserNotFoundException();
    }

    public Vector<User> getUserList() {
        return null;
    }

}
