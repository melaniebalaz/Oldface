package at.omaha17.swe.logic;

import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.Message;
import at.omaha17.swe.model.Post;
import at.omaha17.swe.model.Wall;

import java.util.Vector;

public interface WallManager {
    public Vector<Post> getPosts(Wall wall) throws WallException;
    public void addPost(Wall wall, Senior author, String content) throws WallException;
    public void addComment(Post post, Senior author, String content) throws WallException;
    public Vector<Post> getDashboard(String username) throws WallException;

//  Iteration 2:
//  public void deleteMessage();
//  public void likeMessage();
}
