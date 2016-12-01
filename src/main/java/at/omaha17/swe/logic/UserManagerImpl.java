package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAOInterface;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.User;

public class UserManagerImpl implements UserManager {

    private UserDAOInterface dao;

    public UserManagerImpl(UserDAOInterface dao){
        this.dao = dao;
    }

    public String authenticateUser(String email, String password) throws AuthenticationFailedException{
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

    public Senior createSenior(String email, String password, String displayName){
        return null;
    }

    public User createUser(String role, String email, String password){
        return null;
    }

    public void getDashboard() { }
}
