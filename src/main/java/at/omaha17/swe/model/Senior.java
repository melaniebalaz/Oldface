package at.omaha17.swe.model;


public class Senior extends User {
    
	private Wall wall;

    public Senior(String role, String email, String password) {
        
    	super(role, email, password);
    	setCreation_date();
    	setLogin_date();
    }

    public void blockUser() {
    }
    
    public void changeProfile() {
    }
    
    public void findSenior() {
    }
    
    public void followUser() {
    }
    
    public void findFriends() {
    }
    
    public Wall getWall() {
        return wall;
    }
    
    public void getDashboard() {
    }
}
