package ysu.ldr.mapper;

import org.apache.ibatis.annotations.Param;
import ysu.ldr.pojo.Movie;

import java.util.List;

public interface MovieMapper {
    public List<Movie> selectAllMovie();
    public Integer countAllMovie();
    public Integer updateMovieStatusById(@Param("movieId") Integer movieId,
                                         @Param("show") Boolean show);

    public List<Movie> getMovieByNameSearch(String movieName);

    public Integer addMovie(Movie addMovie);

    public Integer updateMovie(Movie movie);

    public Integer deleteMovie(Integer movieId);

    public List<Movie> getMovieByTypeSearch(@Param("movieType") Integer movieType);

    public Movie getMovieById(Integer movieId);

    public List<Movie> getHotMovies();
}
