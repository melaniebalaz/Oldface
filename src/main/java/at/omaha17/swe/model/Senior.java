package at.omaha17.swe.model;

import java.util.Calendar;
import java.util.Vector;

public class Senior extends User {

    public enum SeniorStatus { ACTIVE, BLOCKED }

    private static final long serialVersionUID = 3L;
    private SeniorStatus status;
    private String displayName;
    private Calendar birthDate;
    private Vector<Follower> followers;

    public Senior(String username, String password) {
    	super(User.ROLE_SENIOR, username, password);
        this.setStatus(SeniorStatus.ACTIVE);
        this.followers = new Vector<Follower>();
    }

    public SeniorStatus getStatus() {
        return status;
    }

    public void setStatus(SeniorStatus status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void addFollower(Follower follower) {
        followers.add(follower);
    }

}
