package at.omaha17.swe.dao;

import java.io.IOException;
import java.util.Vector;
import at.omaha17.swe.model.User;

public interface UserDAO {
	public void saveUser(User user) throws IOException, ClassNotFoundException;
    public void deleteUser(User user) throws IOException, ClassNotFoundException;
    public User getUserByUsername(String username) throws IOException, ClassNotFoundException;
    public Vector<User> getUserList() throws IOException, ClassNotFoundException;
    public boolean isUser(String username) throws IOException, ClassNotFoundException;
}
