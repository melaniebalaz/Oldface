package at.omaha17.swe.model;

import java.util.Vector;

public class Wall {
	
	private Senior senior;
    
	Vector<Post> posts;

	//Kann es sein dass der Wall bei der Kreation leer ist, da er mit einem neuem User kreiert wird 
	//(wir erst später mit posts befüllt?
	
	public Wall() {
		
	}

	public Vector<Post> getPosts() {
		return posts;
	}

	public void setPosts(Vector<Post> posts) {
		this.posts = posts;
	}
    
}
