package at.omaha17.oldface.dao;

import at.omaha17.oldface.model.User;
import at.omaha17.oldface.model.Wall;

public class UserSerialization implements UserDAOInterface {
    public void save(User user){

    }

    public void save(Wall wall){

    }

    public User getByEmail(String email) throws UserNotFoundException{
        return null;
    }

    public Wall getWallbyUser(User user){
        return null;
    }

}
