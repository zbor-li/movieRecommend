package ysu.ldr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ysu.ldr.mapper.CarouselMapper;
import ysu.ldr.pojo.Carousel;
import ysu.ldr.pojo.Movie;
import ysu.ldr.pojo.res.AllMoviesRes;
import ysu.ldr.service.CarouselService;
import ysu.ldr.service.ManagerService;
import ysu.ldr.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/addCarousel/{movieId}/{managerName}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer addCarousel(@PathVariable("movieId") Integer movieId,
                               @PathVariable("managerName") String managerName)

    {
        Integer managerId = managerService.getManagerIdByName(managerName);
        if(carouselService.findCarouselByMovieId(movieId) != 0){
            return 3;
        }
        if(carouselService.getCountAll() == 10){
            return 2;
        }
        return carouselService.addCarousel(movieId, managerId);
    }

    @GetMapping("/getCarouselMovies")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllMoviesRes getCarouselMovies(){
        AllMoviesRes allMoviesRes = new AllMoviesRes();
        List<Movie> movieList = new ArrayList<>();
        List<Carousel> carouselList = carouselService.getAllMovieId();
        allMoviesRes.setTotal(carouselList.size());
        for (int i = 0; i < allMoviesRes.getTotal(); i++) {
            Movie movie = movieService.getMovieById(carouselList.get(i).getMovieId());
            movieList.add(movie);
        }
        allMoviesRes.setMovieList(movieList);
        return allMoviesRes;
    }

    @DeleteMapping("/deleteCarouselMovie/{movieId}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteCarouselMovie(@PathVariable("movieId") Integer movieId) {
        return carouselService.deleteCarouselMovie(movieId);
    }

    @GetMapping("/getCarouselShowMovies")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllMoviesRes getCarouselShowMovies(){
        AllMoviesRes allMoviesRes = new AllMoviesRes();
        List<Movie> movieList = new ArrayList<>();
        List<Carousel> carouselList = carouselService.getAllMovieId();
        for (int i = 0; i < carouselList.size(); i++) {
            Movie movie = movieService.getMovieById(carouselList.get(i).getMovieId());
            if(movie.getShow()){
                movieList.add(movie);
            }
        }
        allMoviesRes.setMovieList(movieList);
        allMoviesRes.setTotal(allMoviesRes.getMovieList().size());
        return allMoviesRes;
    }
}
