package at.omaha17.swe.model;

public class Senior extends User {
    private Wall wall;
    

    public Senior(String email, String password, String displayName) {
        
    	super(User.ROLE_RETIREE, email, password, displayName);
        this.wall = new Wall();
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
