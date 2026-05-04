package ysu.ldr.pojo;

public class Carousel {
    private Integer carouselId;
    private Integer movieId;
    private Integer managerId;

    public Carousel() {
    }

    public Carousel(Integer carouselId, Integer movieId, Integer managerId) {
        this.carouselId = carouselId;
        this.movieId = movieId;
        this.managerId = managerId;
    }

    public Integer getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Integer carouselId) {
        this.carouselId = carouselId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "carouselId=" + carouselId +
                ", movieId=" + movieId +
                ", managerId=" + managerId +
                '}';
    }
}
