package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.*;
import javafx.geometry.Pos;

import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class VisualizationManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");
    private static final MessageDAO messageDAO = new MessageDAOSerialization("MessageDB.ser");
    private static final int postCount = 10;

    public static Wall getWall(String username) throws TechnicalException {

        try {
            return new Wall((Senior) userDAO.getUserByUsername(username), messageDAO.getPostsByUsername(username));

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static Dashboard getDashboard(String username) throws TechnicalException {

        try {
            User user = userDAO.getUserByUsername(username);
            Vector<Post> allPosts = messageDAO.getPostList();
            allPosts.sort(Collections.reverseOrder());

            if (user instanceof Senior) {
                Vector<Post> followerPosts = new Vector<>();

                // get most recent post from each follower
                for (Senior follower : ((Senior) user).getFollowers())
                    followerPosts.add(getRecentUserPost(follower.getUsername()));

                followerPosts.sort(Collections.reverseOrder());
                Dashboard dashboard = new Dashboard(user);

                int index = 0;
                while (index < followerPosts.size() && dashboard.getPosts().size() < postCount) {
                    dashboard.addPost(followerPosts.get(index));
                    index++;
                }

                index = 0;
                while (index < allPosts.size() && dashboard.getPosts().size() < postCount) {
                    if (!dashboard.getPosts().contains(allPosts.get(index))) dashboard.addPost(allPosts.get(index));
                    index++;
                }

                return dashboard;

            } else
                return new Dashboard(user, allPosts);

        } catch (Exception e) { throw new TechnicalException(e);}
    }

    public static void getStatistic() {

    }

    private static Post getRecentUserPost(String username) throws IOException, ClassNotFoundException {

        Vector<Post> posts = messageDAO.getPostsByUsername(username);
        Collections.sort(posts);
        return posts.get(posts.size() - 1);
    }
}
