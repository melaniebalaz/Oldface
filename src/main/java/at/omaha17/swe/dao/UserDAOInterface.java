package at.omaha17.swe.dao;

import java.util.List;
import at.omaha17.swe.model.User;
import at.omaha17.swe.model.Wall;

public interface UserDAOInterface {
	public void save(User user);
    public void save(Wall wall);
    public User getByEmail(String email) throws UserNotFoundException;
    public Wall getWallbyUser(User user) throws WallNotFoundException;
}
