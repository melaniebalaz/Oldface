package at.omaha17.swe.model;

public class Statistic {

    private String userCount;
    private String newUserCount;
    private String loginCount;
    private String seniorStatus;
    private String messageCount;
    private String postStatistic;
    private String commentStatistic;
    private int numberOfCommentsPerPost;
    private double avgPostsPerUser;

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public String getNewUserCount() {
        return newUserCount;
    }

    public void setNewUserCount(String newUserCount) {
        this.newUserCount = newUserCount;
    }

    public String getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(String loginCount) {
        this.loginCount = loginCount;
    }

    public String getSeniorStatus() {
        return seniorStatus;
    }

    public void setSeniorStatus(String seniorStatus) {
        this.seniorStatus = seniorStatus;
    }

    public String getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(String messageCount) {
        this.messageCount = messageCount;
    }

    public String getPostStatistic() {
        return postStatistic;
    }

    public void setPostStatistic(String postStatistic) {
        this.postStatistic = postStatistic;
    }

    public String getCommentStatistic() {
        return commentStatistic;
    }

    public void setCommentStatistic(String commentStatistic) {
        this.commentStatistic = commentStatistic;
    }

    public int getNumberOfCommentsPerPost() {
        return numberOfCommentsPerPost;
    }

    public void setNumberOfCommentsPerPost(int numberOfCommentsPerPost) {
        this.numberOfCommentsPerPost = numberOfCommentsPerPost;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public void setAvgPostsPerUser(double avgPostsPerUser) {
        this.avgPostsPerUser = avgPostsPerUser;
    }

}
