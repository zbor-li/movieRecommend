package ysu.ldr.pojo.rec;

import java.util.Date;

public class AddComment {
    private String userName;
    private Integer movieId;
    private Integer rating;
    private String content;
    private Date timeStamp;

    public AddComment() {
    }

    public AddComment(String userName, Integer movieId, Integer rating, String content, Date timeStamp) {
        this.userName = userName;
        this.movieId = movieId;
        this.rating = rating;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "addComment{" +
                "userName='" + userName + '\'' +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
