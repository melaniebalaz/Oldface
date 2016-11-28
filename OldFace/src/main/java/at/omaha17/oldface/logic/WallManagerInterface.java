package at.omaha17.oldface.logic;

import at.omaha17.oldface.model.Comment;
import at.omaha17.oldface.model.Post;

public interface WallManagerInterface {
    public Post addPost(String post);
    public Post getPost(int id);
    public Comment addComment(String comment);
}
