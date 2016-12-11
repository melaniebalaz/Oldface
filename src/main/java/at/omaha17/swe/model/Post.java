package at.omaha17.swe.model;

import java.util.Vector;

public class Post extends Message {

    private static final long serialVersionUID = 1L;
	private String wall;    //saves username (indirect relation to user due to dao separation)
    private Vector<Comment> comments;

    public Post(Wall wall, Senior author, String content){
        super(author, content);
        this.wall = wall.getUser().getUsername();
        comments = new Vector<Comment>();
    }

    public String getWall() {
        return wall;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

}
