package at.omaha17.swe.model;

import java.util.Calendar;

public abstract class Message {
    
	private Calendar creationDate;
	private String content;
	private String author; //saves username (indirect relation to user)
	
	public Message(String content){
		setCreationDate();
		setContent(content);
	}
	
	public Calendar getCreationDate() {
		return creationDate;}

	public void setCreationDate() {
		Calendar jetzt = Calendar.getInstance();
		this.creationDate = jetzt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		if (content != null){
			this.content = content;
		} else {
		    throw new IllegalArgumentException ("Message has to have content");
		}
	}

}