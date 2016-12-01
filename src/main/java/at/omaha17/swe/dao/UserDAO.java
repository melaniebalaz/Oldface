package at.omaha17.swe.dao;

import java.util.Vector;
import at.omaha17.swe.model.User;

public interface UserDAO {
	public void saveUser(User user);
    public void deleteUser(User user) throws UserNotFoundException;
    public User getUserByUsername(String username) throws UserNotFoundException;
    public Vector<User> getUserList();
}
