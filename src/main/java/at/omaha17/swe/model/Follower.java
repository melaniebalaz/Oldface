package at.omaha17.swe.model;

import java.io.Serializable;
import java.util.Calendar;

public class Follower implements Serializable {

    private static final long serialVersionUID = 1L;
    private Senior follower;
    private Senior follows;
    private Calendar creationDate;

    public Follower(Senior follower, Senior follows) {
        this.follower = follower;
        this.follows = follows;
        this.creationDate = Calendar.getInstance();
    }

    public Senior getFollower() {
        return follower;
    }

    public Senior getFollows() {
        return follows;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }
}
