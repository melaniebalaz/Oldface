package at.omaha17.swe.model;

import java.util.Vector;

public class Post extends Message {

	private Wall wall;
    private Vector<Comment> comments;

    public Post(String content){
        super(content);

    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

}
