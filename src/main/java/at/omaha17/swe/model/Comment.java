package at.omaha17.swe.model;


public class Comment extends Message {

	private Post relatedPost;

    public Comment(String content){
        super(content);

    }

    public Post getRelatedPost() {
        return relatedPost;
    }

}
