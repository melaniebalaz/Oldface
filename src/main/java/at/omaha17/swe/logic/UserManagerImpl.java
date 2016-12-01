package at.omaha17.swe.logic;

import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.User;

public class UserManagerImpl implements UserManager {

    private UserDAO userDAO;

    public UserManagerImpl(){
        this.userDAO = new UserDAOSerialization("UserDB.ser");
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
