package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

public abstract class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private UUID messageid;
	private Calendar creationDate;
	private String content;
	private String author;  //saves username (indirect relation to user due to dao separation)
	
	public Message(Senior author, String content){
	    this.messageid = UUID.randomUUID();
        this.creationDate = Calendar.getInstance();
        this.author = author.getUsername();
		this.content = content;
	}

    public UUID getMessageid() {
        return messageid;
    }

    public Calendar getCreationDate() {
		return creationDate;
	}

    public String getAuthor() {
        return author;
    }

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
        this.content = content;
	}

}