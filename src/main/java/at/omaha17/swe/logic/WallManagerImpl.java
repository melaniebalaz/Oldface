package at.omaha17.swe.logic;

import at.omaha17.swe.dao.WallDAO;
import at.omaha17.swe.dao.WallDAOSerialization;
import at.omaha17.swe.model.Comment;
import at.omaha17.swe.model.Post;

public class WallManagerImpl implements WallManager {

    private WallDAO wallDAO;

    public WallManagerImpl() {
        this.wallDAO = new WallDAOSerialization("WallDB.ser");
    }

    public Post addPost(String post){
        return null;
        //Save the post to the storage
    }

    public Post getPost(int id){
        return null;
    }

    public Comment addComment(String comment){
        return null;
        //Save the comment to the storage
    }
}
