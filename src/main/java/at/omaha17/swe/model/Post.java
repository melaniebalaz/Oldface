package at.omaha17.swe.model;

public class Post extends Message{
	
	public Post(String text){
		super(text);
		
		try{setCreation_date();}
		
		catch (IllegalArgumentException a) {System.out.println(a);}
	}
	
	public void addComment() {
		
	}
	
	public void getComments() {
		
	}
}
