package ysu.ldr.pojo.res;

import ysu.ldr.pojo.Movie;

import java.util.List;

public class AllMoviesRes {
    private List<Movie> movieList;
    private Integer total;

    public AllMoviesRes() {
    }

    public AllMoviesRes(List<Movie> movieList, Integer total) {
        this.movieList = movieList;
        this.total = total;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
