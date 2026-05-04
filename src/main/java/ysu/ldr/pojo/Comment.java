package ysu.ldr.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Comment {
    private Integer commentId;
    private Integer userId;
    private Integer movieId;
    private String content;
    private Integer rating;
    private Date timeStamp;

    public Comment() {
    }

    public Comment(Integer commentId, Integer userId, Integer movieId, String content, Integer rating, Date timeStamp) {
        this.commentId = commentId;
        this.userId = userId;
        this.movieId = movieId;
        this.content = content;
        this.rating = rating;
        this.timeStamp = timeStamp;
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

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
