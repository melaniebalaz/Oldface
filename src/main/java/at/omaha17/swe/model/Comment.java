package at.omaha17.swe.model;


public class Comment extends Message{
	
	public Comment(String text){
		super(text);
		
		try{setCreation_date();}
		
		catch (IllegalArgumentException a) {System.out.println(a);}
	}
}
