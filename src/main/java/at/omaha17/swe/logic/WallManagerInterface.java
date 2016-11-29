package at.omaha17.swe.logic;

import at.omaha17.swe.model.Comment;
import at.omaha17.swe.model.Post;

public interface WallManagerInterface {
    public Post addPost(String post);
    public Post getPost(int id);
    public Comment addComment(String comment);
}
