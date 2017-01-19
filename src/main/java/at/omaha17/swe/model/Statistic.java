package at.omaha17.swe.model;

public class Statistic {

    private String userCount;
    private int numberOfPosts;
    private int postsPerDay;
    private int postLength;
    private int numberOfCommentsPerPost;
    private int commentsPerDay;
    private int commentLength;
    private int loginsPerDay;
    private double avgPostsPerUser;

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public int getPostsPerDay() {
        return postsPerDay;
    }

    public void setPostsPerDay(int postsPerDay) {
        this.postsPerDay = postsPerDay;
    }

    public int getPostLength() {
        return postLength;
    }

    public void setPostLength(int postLength) {
        this.postLength = postLength;
    }

    public int getNumberOfCommentsPerPost() {
        return numberOfCommentsPerPost;
    }

    public void setNumberOfCommentsPerPost(int numberOfCommentsPerPost) {
        this.numberOfCommentsPerPost = numberOfCommentsPerPost;
    }

    public int getCommentsPerDay() {
        return commentsPerDay;
    }

    public void setCommentsPerDay(int commentsPerDay) {
        this.commentsPerDay = commentsPerDay;
    }

    public int getCommentLength() {
        return commentLength;
    }

    public void setCommentLength(int commentLength) {
        this.commentLength = commentLength;
    }

    public int getLoginsPerDay() {
        return loginsPerDay;
    }

    public void setLoginsPerDay(int loginsPerDay) {
        this.loginsPerDay = loginsPerDay;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public void setAvgPostsPerUser(double avgPostsPerUser) {
        this.avgPostsPerUser = avgPostsPerUser;
    }

}
