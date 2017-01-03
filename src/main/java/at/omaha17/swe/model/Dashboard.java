package at.omaha17.swe.model;

import java.util.Vector;

public class Dashboard {

    private Senior user;
    private Vector<Message> messages;

    public Dashboard(Senior user, Vector<Message> messages) {
        this.user = user;
        this.messages = messages;
    }

    public Senior getUser() {
        return user;
    }

    public Vector<Message> getMessages() {
        return messages;
    }
}
