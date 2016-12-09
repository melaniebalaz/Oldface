package at.omaha17.swe.model;


public class Comment extends Message {

    private static final long serialVersionUID = 1L;
	private Post relatedPost;

    public Comment(Post relatedPost, String author, String content){
        super(author, content);
        this.relatedPost = relatedPost;
    }

    public Post getRelatedPost() {
        return relatedPost;
    }

}
