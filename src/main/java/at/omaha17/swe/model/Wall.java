package at.omaha17.swe.model;

import java.util.Vector;
import at.omaha17.swe.model.Post;
import at.omaha17.swe.model.Senior;

<<<<<<< HEAD
	public Wall(Vector<Post> posts) {
		
		this.posts = posts;
=======
public class Wall {
	
	private Senior senior;
    
	Vector<Post> posts;

	//Kann es sein dass der Wall bei der Kreation leer ist, da er mit einem neuem User kreiert wird 
	//(wir erst später mit posts befüllt?
	
	public Wall() {
>>>>>>> branch 'master' of https://gitta-lab.cs.univie.ac.at/swe16/g6t2.git
		
	}

<<<<<<< HEAD
	
=======
	public Vector<Post> getPosts() {
		return posts;
	}

	public void setPosts(Vector<Post> posts) {
		this.posts = posts;
	}
>>>>>>> branch 'master' of https://gitta-lab.cs.univie.ac.at/swe16/g6t2.git
    
}
