package ysu.ldr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.Movie;
import ysu.ldr.pojo.res.AllMoviesRes;
import ysu.ldr.pojo.res.CommentWithUserName;
import ysu.ldr.service.CommentService;
import ysu.ldr.service.MovieService;
import ysu.ldr.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping("/getMoviesByType")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllMoviesRes findMovieByType(@RequestParam("query") Integer movieType,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize)
    {
        System.out.println(movieType);
        System.out.println();
        System.out.println();
        AllMoviesRes allMoviesResPage = new AllMoviesRes();
        List<Movie> movieList = movieService.getMovieByTypeSearch(movieType);
        int total = movieList.size();
        int i = (pageNum - 1) * pageSize;
        int max = pageNum * pageSize;
        max = Math.min(max, total);
        if(i >= max || total == 0) {
            i = 0;
        }
        List<Movie> movieListPage = new ArrayList<>(max - i);
        allMoviesResPage.setTotal(total);

        for(; i < max; i++){
            movieListPage.add(movieList.get(i));
        }
        allMoviesResPage.setMovieList(movieListPage);
        return allMoviesResPage;
    }

    @GetMapping("/getMovieComments/{movieId}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public List<CommentWithUserName> getMovieComments(@PathVariable("movieId") Integer movieId){
        List<Comment> commentList = commentService.getCommentByMovieId(movieId);
        int length = commentList.size();
        List<CommentWithUserName> commentWithUserNameList = new ArrayList<>(length);
        for (Comment comment : commentList) {
            CommentWithUserName commentWithUserName = new CommentWithUserName();
            commentWithUserName.setCommentId(comment.getCommentId());
            commentWithUserName.setUserId(comment.getUserId());
            commentWithUserName.setMovieId(comment.getMovieId());
            commentWithUserName.setContent(comment.getContent());
            commentWithUserName.setTimeStamp(comment.getTimeStamp());
            commentWithUserName.setRating(comment.getRating());
            commentWithUserName.setUserName(userService.getUserNameById(comment.getUserId()));
            commentWithUserNameList.add(commentWithUserName);
        }
        return commentWithUserNameList;
    }

    @GetMapping("/getHotMovies")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public List<Movie> getHotMovies(){

        return movieService.getHotMovies();
    }

}
