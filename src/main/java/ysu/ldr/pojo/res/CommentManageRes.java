package ysu.ldr.pojo.res;

import java.util.Date;

public class CommentManageRes {
    private Integer commentId;
    private Integer userId;
    private String userName;
    private Boolean commentStatus;
    private String movieName;
    private String content;
    private Date timestamp;
    private Integer rating;

    public CommentManageRes() {
    }

    public CommentManageRes(Integer commentId, Integer userId, String userName, Boolean commentStatus, String movieName, String content, Date timestamp, Integer rating) {
        this.commentId = commentId;
        this.userId = userId;
        this.userName = userName;
        this.commentStatus = commentStatus;
        this.movieName = movieName;
        this.content = content;
        this.timestamp = timestamp;
        this.rating = rating;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CommentManageRes{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", commentStatus=" + commentStatus +
                ", movieName='" + movieName + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", rating=" + rating +
                '}';
    }
}
