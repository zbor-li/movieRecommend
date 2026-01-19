package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.MovieMapper;
import ysu.ldr.pojo.Movie;
import ysu.ldr.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> getAllMovie() {
        return movieMapper.selectAllMovie();
    }

    @Override
    public Integer getCountOfMovie() {
        return movieMapper.countAllMovie();
    }

    @Override
    public Integer updateMovieStatusById(Integer movieId, Boolean show) {
        return movieMapper.updateMovieStatusById(movieId, show);
    }

    @Override
    public List<Movie> getMovieByNameSearch(String movieName) {

        return movieMapper.getMovieByNameSearch(movieName);
    }

    @Override
    public Integer addMovie(Movie addMovie) {
        return movieMapper.addMovie(addMovie);
    }

    @Override
    public Integer updateMovie(Movie movie) {
        return movieMapper.updateMovie(movie);
    }

    @Override
    public Integer deleteMovie(Integer movieId) {
        return movieMapper.deleteMovie(movieId);
    }

    @Override
    public List<Movie> getMovieByTypeSearch(Integer movieType) {
        return movieMapper.getMovieByTypeSearch(movieType);
    }

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieMapper.getMovieById(movieId);
    }

    @Override
    public List<Movie> getHotMovies() {
        return movieMapper.getHotMovies();
    }
}
