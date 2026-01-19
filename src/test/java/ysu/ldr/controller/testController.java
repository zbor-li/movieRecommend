package ysu.ldr.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ysu.ldr.pojo.Movie;
import ysu.ldr.service.MovieService;

import java.util.List;

@RestController
public class testController {
    @Autowired
    MovieService movieService;
    @Test
    @GetMapping("/findAllMovie")
    //Ω” ’øÁ”Ú«Î«Û
    @CrossOrigin(origins = "http://127.0.0.1:5176")
    public void findAllMovie(){
        List<Movie> movieList = movieService.getAllMovie();
        movieList.forEach(System.out::println);
    }

}
