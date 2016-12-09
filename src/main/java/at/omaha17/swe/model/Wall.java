package at.omaha17.swe.model;

import java.io.Serializable;

public class Wall implements Serializable {

	private static final long serialVersionUID = 1L;
	private Senior user;

	public Wall(Senior user) {
	    this.user = user;
    }

    public Senior getUser() {
        return user;
    }

}