package at.omaha17.swe.logic;

import at.omaha17.swe.model.Retiree;
import at.omaha17.swe.model.User;

public interface UserManagerInterface {

    public String authenticate(String email, String password) throws AuthenticationFailedException;

    public User getUser(String authenticationToken);

    public Retiree createRetiree(String email, String password, String displayName);

    public User createUser(String role, String email, String password);
}
