package ysu.ldr.pojo;

import java.sql.Date;

public class Movie {
    private Integer movieId;
    private String movieName;
    private Date releaseDate;
    private String movieNation;
    private String directors;
    private String leadactors;
    private String editors;
    private String picture;
    private float avgRating;
    private Integer numRating;
    private String description;
    private String poster;
    private Integer typeId;
    private Boolean show;

    public Movie(Integer movieId, String movieName, Date releaseDate, String movieNation, String directors, String leadactors, String editors, String picture, float avgRating, Integer numRating, String description, String poster, Integer typeId, Boolean show) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.movieNation = movieNation;
        this.directors = directors;
        this.leadactors = leadactors;
        this.editors = editors;
        this.picture = picture;
        this.avgRating = avgRating;
        this.numRating = numRating;
        this.description = description;
        this.poster = poster;
        this.typeId = typeId;
        this.show = show;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", releaseDate=" + releaseDate +
                ", movieNation='" + movieNation + '\'' +
                ", directors='" + directors + '\'' +
                ", leadactors='" + leadactors + '\'' +
                ", editors='" + editors + '\'' +
                ", picture='" + picture + '\'' +
                ", avgRating=" + avgRating +
                ", numRating=" + numRating +
                ", description='" + description + '\'' +
                ", poster='" + poster + '\'' +
                ", typeId=" + typeId +
                ", show=" + show +
                '}';
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieNation() {
        return movieNation;
    }

    public void setMovieNation(String movieNation) {
        this.movieNation = movieNation;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getLeadactors() {
        return leadactors;
    }

    public void setLeadactors(String leadactors) {
        this.leadactors = leadactors;
    }

    public String getEditors() {
        return editors;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public Integer getNumRating() {
        return numRating;
    }

    public void setNumRating(Integer numRating) {
        this.numRating = numRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
