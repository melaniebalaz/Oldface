package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Vector;

public class Wall implements Serializable {
    
	private int wallid;
	private String username; //indirect user relation (due to DAO separation)
	private Vector<Post> posts;
	
	public Wall(String username) {
	    // auto-gen wallid
	    this.username = username;

    }

	public Vector<Post> getPosts() {
	    return posts;
	}

	public void setPosts(Vector<Post> posts) {
	    this.posts = posts;
	}
}

