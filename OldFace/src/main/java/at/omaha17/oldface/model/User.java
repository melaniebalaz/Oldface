package at.omaha17.oldface.model;

import java.io.Serializable;

import java.util.Vector;

public class User implements Serializable {
    public final static String ROLE_RETIREE = "Retiree";
    public final static String ROLE_ADMIN = "Admin";
    public final static String ROLE_RESEARCHER = "Researcher";

	private String role = ROLE_RETIREE;
    private String email;
    private String password;
    private String displayName;
    private Vector<String> authenticationTokens;


    public User(String role, String email, String password,String displayName) {
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }
}
