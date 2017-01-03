package at.omaha17.swe.model;

import java.util.Vector;

public class Wall {

	private Senior user;
	private Vector<Post> posts;

	public Wall(Senior user, Vector<Post> posts) {
	    this.user = user;
	    this.posts = posts;
    }

    public Senior getUser() {
        return user;
    }

    public Vector<Post> getPosts() {
        return posts;
    }
}