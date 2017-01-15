package at.omaha17.swe.model;

import java.util.Vector;

public class Dashboard {

    private User user;
    private Vector<Post> posts;

    public Dashboard(User user, Vector<Post> posts) {
        this.user = user;
        this.posts = posts;
    }

    public Dashboard(User user) {
        this(user, new Vector<>());
    }

    public User getUser() {
        return user;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void setPosts(Vector<Post> posts) {
        this.posts = posts;
    }

    public Vector<Post> getPosts() {
        return posts;
    }
}
