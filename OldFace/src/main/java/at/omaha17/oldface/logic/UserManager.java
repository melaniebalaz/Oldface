package at.omaha17.oldface.logic;

import at.omaha17.oldface.dao.UserDAOInterface;
import at.omaha17.oldface.model.Retiree;
import at.omaha17.oldface.model.User;

public class UserManager {

    UserDAOInterface dao;

    public UserManager(UserDAOInterface dao){
        this.dao = dao;
    }

    public String authenticate(String email, String password) throws AuthenticationFailedException{
       return "AuthenticationToken";
    }

    /**
     * Fetch the current user
     * @param authenticationToken Token by which to identify a user
     * @return a User identified by this token
     */
    public User getUser(String authenticationToken){
        return null;
    }

    public Retiree createRetiree(String email, String password, String displayName){
        return null;
    }

    public User createUser(String role, String email, String password){
        return null;
    }
}
