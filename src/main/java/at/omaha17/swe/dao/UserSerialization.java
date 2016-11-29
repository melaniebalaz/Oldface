package at.omaha17.swe.dao;

import at.omaha17.swe.model.User;
import at.omaha17.swe.model.Wall;

import java.io.Serializable;

public class UserSerialization implements UserDAOInterface, Serializable{
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
