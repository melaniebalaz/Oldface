package at.omaha17.oldface.dao;
import java.util.List;

import at.omaha17.oldface.model.User;
import at.omaha17.oldface.model.Wall;

public interface UserDAOInterface {
	public void save(User user);
    public void save(Wall wall);
    public User getByEmail(String email) throws UserNotFoundException;
    public Wall getWallbyUser(User user) throws WallNotFoundException;
}
