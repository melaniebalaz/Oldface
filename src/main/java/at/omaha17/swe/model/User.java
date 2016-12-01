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


    public User(String role, String email, String password) {
        this.role = role;
        try{
        	setEmail(email);
        	setPassword(password);
        	setCreation_date();
        	setLogin_date();
        }
        catch (IllegalArgumentException a) {System.out.println(a);}
        
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    
   	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setCreation_date() {
    	
		if(this.creation_date != null){}
    	else {this.creation_date = Calendar.getInstance();}
	}
	

	public Calendar getCreation_date() {
    	return creation_date;
	}

	public void setLogin_date() {
		this.creation_date = Calendar.getInstance();
	}

	public Calendar getLogin_date() {
		return login_date;
	}
	
    /*public String getDisplayName() {
        return displayName;
    }*/
}
