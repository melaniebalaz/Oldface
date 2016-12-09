package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Calendar;

public class User implements Serializable {

    public final static String ROLE_SENIOR = "Senior";
    public final static String ROLE_ADMIN = "Admin";
    public final static String ROLE_RESEARCHER = "Researcher";

    private static final long serialVersionUID = 1L;
	private String role;
    private String username;
    private String password;
    private Calendar creationDate;
    private Calendar loginDate;

    public User(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.creationDate = Calendar.getInstance();
        this.loginDate = null;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

	public Calendar getCreationDate() {
    	return creationDate;
	}

    public Calendar getLoginDate() {
        return loginDate;
    }

	public void setLoginDate() {
		this.creationDate = Calendar.getInstance();
	}

}
