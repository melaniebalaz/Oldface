package at.omaha17.swe.model;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;

public class User {
    public final static String ROLE_SENIOR = "Senior";
    public final static String ROLE_ADMIN = "Admin";
    public final static String ROLE_RESEARCHER = "Researcher";

	private String role = ROLE_SENIOR;
    private String email;
    private String password;
    //private String displayName;
    private Calendar creation_date;
    private Calendar login_date;
    private Vector<String> authenticationTokens;


    public User(String role, String email, String password, Calendar creation_date, Calendar login_date) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.creation_date = creation_date;
        this.login_date = login_date;
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
    
    public void setCreation_date(Calendar creation_date) {
    	Calendar jetzt = Calendar.getInstance();
		this.creation_date = jetzt;
	}
    
    public Calendar getCreation_date() {
    	return creation_date;
	}

	public void setLogin_date(Calendar login_date) {
		Calendar jetzt = Calendar.getInstance();
		this.creation_date = jetzt;
	}

	public Calendar getLogin_date() {
		return login_date;
	}
	
    /*public String getDisplayName() {
        return displayName;
    }*/
}
