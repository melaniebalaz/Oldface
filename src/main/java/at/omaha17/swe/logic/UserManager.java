package at.omaha17.swe.logic;

import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.User;

public interface UserManager {

    public User registerUser(String role, String username, String password) throws RegistrationFailedException;
    public User authenticateUser(String username, String password) throws AuthenticationFailedException;
    public User getUser(String username);
    public void getDashboard();

//    public void blockSenior();
//    public void changeProfile();
//    public void findSenior();
//    public void followSenior();
//    public void findFriends();
}
