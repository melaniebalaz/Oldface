package at.omaha17.swe.model;

import java.util.Calendar;
import at.omaha17.swe.model.Wall;

public class Senior extends User {
    private Wall wall;
    

    public Senior(String role, String email, String password, Calendar creation_date, Calendar login_date) {
        
    	super(role, email, password, creation_date, login_date);
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
