package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;
import java.util.Vector;

public abstract class Message implements Serializable, Comparable<Message> {

    private static final long serialVersionUID = 3L;
    private UUID messageid;
	private Calendar creationDate;
	private String content;
	private String author;              //saves username as string (indirect relation to user due to dao separation)
    private Vector<String> likers;      //saves username as string (indirect relation to user due to dao separation)
	
	public Message(Senior author, String content){
	    this.messageid = UUID.randomUUID();
        this.creationDate = Calendar.getInstance();
        this.author = author.getUsername();
		this.content = content;
		this.likers = new Vector<>();
	}

    public String getMessageid() {
        return messageid.toString();
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

	public Vector<String> getLikers() {
	    return likers;
    }

    public void addLiker(Senior liker) {
	    likers.add(liker.getUsername());
    }

    @Override
    public int compareTo(Message message) {
        return this.getCreationDate().compareTo(message.getCreationDate());
    }

    @Override
    public boolean equals(Object obj) {
        return this.getMessageid().equals(((Message) obj).getMessageid());
    }
}