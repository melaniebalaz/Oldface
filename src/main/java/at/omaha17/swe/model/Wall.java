package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Vector;

public class Wall implements Serializable {

	private String username; //indirect user relation (due to DAO separation)
	private Vector<Post> posts;

	public Wall(String username) {
	    this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Vector<Post> getPosts() {
	    return posts;
	}

}