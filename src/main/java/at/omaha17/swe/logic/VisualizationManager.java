package at.omaha17.swe.logic;

import at.omaha17.swe.dao.MessageDAO;
import at.omaha17.swe.dao.MessageDAOSerialization;
import at.omaha17.swe.dao.UserDAO;
import at.omaha17.swe.dao.UserDAOSerialization;
import at.omaha17.swe.model.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;

public class VisualizationManager {

    private static final UserDAO userDAO = new UserDAOSerialization("UserDB.ser");
    private static final MessageDAO messageDAO = new MessageDAOSerialization("MessageDB.ser");
    private static final int postDisplayCount = 10;

    public static Wall getWall(String username) throws TechnicalException {

        try {
            Vector<Post> posts = messageDAO.getPostsByUsername(username);
            if (posts != null) posts.sort(Collections.reverseOrder());
            return new Wall((Senior) userDAO.getUserByUsername(username), posts);

        } catch (IOException|ClassNotFoundException|IllegalArgumentException e) { throw new TechnicalException(e); }
    }

    public static Dashboard getDashboard(String username) throws TechnicalException {

        try {
            User user = userDAO.getUserByUsername(username);
            Vector<Post> allPosts = messageDAO.getPostList();
            if (allPosts == null) return new Dashboard(user);
            Dashboard dashboard = new Dashboard(user);

            if (user instanceof Senior) {
                Vector<Post> followerPosts = new Vector<>();

                // get most recent post from each follower
                for (Senior follower : ((Senior) user).getFollowers())
                    followerPosts.add(getRecentUserPost(follower.getUsername()));

                followerPosts.sort(Collections.reverseOrder());

                int index = 0;
                while (index < followerPosts.size() && dashboard.getPosts().size() < postDisplayCount) {
                    dashboard.addPost(followerPosts.get(index));
                    index++;
                }
            }

            // fill up with other posts until postCount is reached
            allPosts.sort(Collections.reverseOrder());
            int index = 0;
            while (index < allPosts.size() && dashboard.getPosts().size() < postDisplayCount) {
                if (!dashboard.getPosts().contains(allPosts.get(index))) dashboard.addPost(allPosts.get(index));
                index++;
            }

            return dashboard;

        } catch (Exception e) { throw new TechnicalException(e);}
    }

    public static Statistic getStatistic() throws TechnicalException {

        try {
            Statistic statistic = new Statistic();
            Vector<User> users = userDAO.getUserList();
            Vector<Message> messages = messageDAO.getMessageList();
            Calendar now = Calendar.getInstance();

            int numOfSenior = 0, numOfAdmins = 0, numOfResearchers = 0, numOfActiveSenior = 0, numOfBlockedSenior = 0;
            int numOfNewUserToday = 0, numOfNewUserMonth = 0, numOfNewUserYear = 0, numOfLoginsToday = 0, numOfLoginsMonth = 0, numOfLoginsYear = 0;

            for (User user : users) {
                if (user.getRole().equals(User.ROLE_ADMIN)) numOfAdmins++;
                if (user.getRole().equals(User.ROLE_RESEARCHER)) numOfResearchers++;
                if (user instanceof Senior) {
                    numOfSenior++;
                    if (((Senior) user).getStatus().equals(Senior.SeniorStatus.ACTIVE)) numOfActiveSenior++;
                    if (((Senior) user).getStatus().equals(Senior.SeniorStatus.BLOCKED)) numOfBlockedSenior++;
                }

                if (user.getCreationDate().get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
                    numOfNewUserYear++;
                    if (user.getCreationDate().get(Calendar.MONTH) == now.get(Calendar.MONTH)) {
                        numOfNewUserMonth++;
                        if (user.getCreationDate().get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH))
                            numOfNewUserToday++;
                    }
                }

                if (user.getLoginDate() != null && user.getLoginDate().get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
                    numOfLoginsYear++;
                    if (user.getLoginDate().get(Calendar.MONTH) == now.get(Calendar.MONTH)) {
                        numOfLoginsMonth++;
                        if (user.getLoginDate().get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH))
                            numOfLoginsToday++;
                    }
                }
            }
            statistic.setUserCount("Insgesamt: " + users.size() + " --> Senior: " + numOfSenior + " / Admins: " + numOfAdmins + " / Forscher: " + numOfResearchers);
            statistic.setNewUserCount("Heute: " + numOfNewUserToday + " / dieses Monat: " + numOfNewUserMonth + " / dieses Jahr: " + numOfNewUserYear);
            statistic.setLoginCount("Heute: " + numOfLoginsToday + " / dieses Monat: " + numOfLoginsMonth + " / dieses Jahr: " + numOfLoginsYear);
            statistic.setSeniorStatus("Aktive Profile: " + numOfActiveSenior + " / Gesperrte Profile: " + numOfBlockedSenior);

            int numOfPosts = 0, numOfComments = 0, numOfPostsToday = 0, numOfPostsMonth = 0, numOfPostsYear = 0, numOfCommentsToday = 0, numOfCommentsMonth = 0, numOfCommentsYear = 0;
            for (Message message : messages) {
                if (message instanceof Post) numOfPosts++;
                if (message instanceof Comment) numOfComments++;

                if (message.getCreationDate().get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
                    if (message instanceof Post) numOfPostsYear++;
                    else numOfCommentsToday++;
                    if (message.getCreationDate().get(Calendar.MONTH) == now.get(Calendar.MONTH)) {
                        if (message instanceof Post) numOfPostsMonth++;
                        else numOfCommentsMonth++;
                        if (message.getCreationDate().get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH))
                            if (message instanceof Post) numOfPostsToday++;
                            else numOfCommentsYear++;
                    }
                }
            }
            statistic.setMessageCount("Insgesamt: " + messages.size() + " --> Posts: " + numOfPosts + " / Kommentare: " + numOfComments);
            statistic.setPostStatistic("Heute: " + numOfPostsToday + " / dieses Monat: " + numOfPostsMonth + " / dieses Jahr: " + numOfPostsYear);
            statistic.setCommentStatistic("Heute: " + numOfCommentsToday + " / dieses Monat: " + numOfCommentsMonth + " / dieses Jahr: " + numOfCommentsYear);

            return statistic;

        } catch (Exception e) { throw new TechnicalException(e);}
    }

    private static Post getRecentUserPost(String username) throws IOException, ClassNotFoundException {

        Vector<Post> posts = messageDAO.getPostsByUsername(username);
        if (posts == null) return null;
        Collections.sort(posts);
        return posts.get(posts.size() - 1);
    }
}
