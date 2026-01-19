package ysu.ldr.controller;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.Movie;
import ysu.ldr.pojo.recommend.DatTransf;
import ysu.ldr.pojo.recommend.MyRecommender;
import ysu.ldr.pojo.recommend.TransfToDat;
import ysu.ldr.pojo.res.AllMoviesRes;
import ysu.ldr.service.CommentService;
import ysu.ldr.service.MovieService;
import ysu.ldr.service.RecommendationService;
import ysu.ldr.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemCFController {
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RecommendationService recommendationService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/getItemCF/{userName}/{recommendSize}")
    //接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public AllMoviesRes getItemCFCommend(@PathVariable("userName") String userName,
                                         @PathVariable("recommendSize") int size) throws ClassNotFoundException, TasteException, IOException {
        AllMoviesRes allMoviesRes = new AllMoviesRes();
        List<Movie> movieList = new ArrayList<>();
        //先把数据库数据导入到外部txt文件，再进行推荐，性能提升给我的感觉有100倍吧
        List<DatTransf> datTransfList = commentService.getCommentToDat();
        TransfToDat transfToDat = new TransfToDat();
        transfToDat.transfToDat(datTransfList);
        int total = 0;
        //标识是否进行推荐结果存储
        boolean flag = false;
        //根据name得到用户id
        Integer userId = userService.getUserByName(userName);
        //从数据库获取推荐结果
        String itemCFStr = recommendationService.getItemCFRecommends(userId);
        //推荐结果转换为int数组的中间字符串数组
        String[] itemCFMoviesString = null;
        //存储推荐结果字符串
        int[] itemCFMoviesId = null;
        //如果没有获取到已经存储的推荐结果，那就进行推荐，获取到推荐结果就把推荐结果转换为int数组
        if(itemCFStr != null && !itemCFStr.equals("")){
            itemCFMoviesString = itemCFStr.split(",");
            total = itemCFMoviesString.length;
            itemCFMoviesId = new int[total];
            for (int i = 0; i < total; i++) {
                itemCFMoviesId[i] = Integer.parseInt(itemCFMoviesString[i]);
            }
        }
        else if(commentService.getCommentByUserId(userId) != 0){
            MyRecommender myRecommender = new MyRecommender();
            itemCFMoviesId = myRecommender.itemCF(userId, size);
            flag = true;
            total = itemCFMoviesId.length;
        }
        //推荐存入数据库
        if(flag){
            //idea 警告推荐的字符串拼接量，推荐结果拼接为字符串
            String recommendations = "";
            //将数组拼接为字符串
            for (int i = 0; i < total; i++) {
                if (i == total - 1) {
                    recommendations += itemCFMoviesId[i];
                } else {
                    recommendations += itemCFMoviesId[i] + ",";
                }
            }
            //转换为String方便存入数据库
            String recommends = recommendations.toString();
            //将推荐结果存入数据库,(如果成功存入就继续推荐，没有成功存入，就返回null，保持前端看到的推荐结果与数据库一致)
            if(recommends.equals("")){
                return null;
            }
            if(recommendationService.insertItemCFRecommends(userId, recommends) == 0){
                return null;
            }
        }
        //获得到推荐就将推荐电影依次取出
        if(total > 0 ){
            allMoviesRes.setTotal(total);
            for(int i = 0; i < total; i++){
                Movie movie = movieService.getMovieById(itemCFMoviesId[i]);
                movieList.add(movie);
            }
            allMoviesRes.setMovieList(movieList);
            return allMoviesRes;
        }
        return null;
    }

}
