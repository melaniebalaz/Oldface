package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;

public class User implements Serializable {
    public final static String ROLE_SENIOR = "Senior";
    public final static String ROLE_ADMIN = "Admin";
    public final static String ROLE_RESEARCHER = "Researcher";

	private String role;
    private String username;
    private String password;
    private Calendar creationDate;
    private Calendar loginDate;
    private Vector<String> authenticationTokens;


    public User(String role, String username, String password) {
        this.role = role;
        this.creationDate = Calendar.getInstance();
        setUsername(username);
        setPassword(password);
        setLoginDate();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
   	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
        this.password = password;
    }

	public Calendar getCreationDate() {
    	return creationDate;
	}

	public void setLoginDate() {
		this.creationDate = Calendar.getInstance();
	}

	public Calendar getLoginDate() {
		return loginDate;
	}

}
