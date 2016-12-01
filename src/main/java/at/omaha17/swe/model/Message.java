package at.omaha17.swe.model;

import java.util.Calendar;

public abstract class Message {
    
	protected Calendar creation_date;

	private String text;
	
	public Message(String text){
		try{
			setCreation_date();
			setContent(text);
		}
		catch (IllegalArgumentException a) {System.out.println(a);}
	}
	
	public Calendar getCreation_date() {
		return creation_date;}

	public void setCreation_date() {
		Calendar jetzt = Calendar.getInstance();
		this.creation_date = jetzt;}

	public String getContent() {
		return text;}

	public void setContent(String Text) {
		if (Text != null){
			this.text = Text;
			}
		
		else
		{throw new IllegalArgumentException ("Message has to have content");
		}
	}
	
	public void deleteMessage(){
		
	}
	
	public void likeMessage(){
		
	}
}