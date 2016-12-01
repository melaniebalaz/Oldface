package at.omaha17.swe.model;

public class Post extends Message{
	
	public Post(String Content){
		super(Content);
		
		try{setCreation_date();}
		
		catch (IllegalArgumentException a) {System.out.println(a);}
	}
	
	public void addComment() {
		
	}
	
	public void getComments() {
		
	}
}
