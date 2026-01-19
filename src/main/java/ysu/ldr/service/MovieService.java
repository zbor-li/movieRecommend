package ysu.ldr.service;

import ysu.ldr.pojo.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getAllMovie();
    public Integer getCountOfMovie();
    public Integer updateMovieStatusById(Integer movieId, Boolean show);

    public List<Movie> getMovieByNameSearch(String movieName);

    public Integer addMovie(Movie addMovie);

    public Integer updateMovie(Movie movie);

    public Integer deleteMovie(Integer movieId);

    public List<Movie> getMovieByTypeSearch(Integer movieType);

    public Movie getMovieById(Integer movieId);

    public List<Movie> getHotMovies();
}
