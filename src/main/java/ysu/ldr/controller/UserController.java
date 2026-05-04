package ysu.ldr.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.ReportComment;
import ysu.ldr.pojo.User;
import ysu.ldr.pojo.rec.AddComment;
import ysu.ldr.pojo.rec.AddReportCommentRec;
import ysu.ldr.pojo.recommend.DatTransf;
import ysu.ldr.pojo.recommend.MyRecommender;
import ysu.ldr.pojo.recommend.TransfToDat;
import ysu.ldr.service.CommentService;
import ysu.ldr.service.ReportCommentService;
import ysu.ldr.service.UserService;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ReportCommentService reportCommentService;

    @PostMapping("/userLogin")
    // 接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public boolean userLogin(@RequestParam("userName") String userName,
            @RequestParam("password") String password) {
        // MyRecommender myRecommender = new MyRecommender();
        // myRecommender.userCF(userService.getUserByName(userName), 5);
        boolean isLogin = userService.isLogin(userName, password);
        // System.out.println("<<<<userName: " + userName + " " + "password: " +
        // password + ">>>>");
        // List<DatTransf> datTransfList = commentService.getCommentToDat();
        // 测试成功，转写入userCFController和iteam，，，nice,目前结果已经秒出了
        // TransfToDat transfToDat = new TransfToDat();
        // transfToDat.transfToDat(datTransfList);
        return isLogin;
    }

    @PostMapping("/registerUser")
    // 接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer registerUser(@RequestBody User addUser) {
        return userService.addUser(addUser);
    }

    @GetMapping("/getUserRating/{userName}/{movieId}")
    // 接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer getUserRating(@PathVariable("userName") String userName,
            @PathVariable("movieId") Integer movieId) {
        Integer userId = userService.getUserByName(userName);
        if (userId != null) {
            return commentService.getRatingByUserAndMovie(userId, movieId);
        }
        return null;
    }

    @GetMapping("/getUserName/{userId}")
    // 接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public String getUserNameById(@PathVariable("userId") Integer userId) {
        return userService.getUserNameById(userId);
    }

    @GetMapping("/getUserCommenet/{userName}/{movieId}")
    // 接收跨域请求
    @CrossOrigin(origins = "http://localhost:5176")
    public String getUserComment(@PathVariable("userName") String userName,
            @PathVariable("movieId") Integer movieId) {
        Integer userId = userService.getUserByName(userName);
        System.out.println("Name: " + userName + "," + "," + "id: " + userId + "," + "mid: " + movieId);
        if (userId != null) {
            return commentService.getCommentByUserAndMovie(userId, movieId);
        }
        return null;
    }

    @PostMapping("/addComment")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer addComment(@RequestBody AddComment addComment) {
        Integer userId = userService.getUserByName(addComment.getUserName());
        if (userId != null) {
            String commentIsIn = commentService.getCommentByUserAndMovie(userId, addComment.getMovieId());
            if (!Objects.equals(commentIsIn, null)) {
                return 2;
            } else if (!userService.getUserById(userId).getCommentStatus()) {
                return 3;
            } else {
                Comment comment = new Comment((Integer) null, userId, addComment.getMovieId(), addComment.getContent(),
                        addComment.getRating(), addComment.getTimeStamp());
                return commentService.addComment(comment);
            }
        }
        return null;
    }

    @DeleteMapping("/deleteComment/{userName}/{movieId}")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer deleteComment(@PathVariable("userName") String userName,
            @PathVariable("movieId") Integer movieId) {
        Integer userId = userService.getUserByName(userName);
        if (userId != null) {
            return commentService.deleteComment(userId, movieId);
        }
        return null;
    }

    @PostMapping("/addReportComment")
    @CrossOrigin(origins = "http://localhost:5176")
    public Integer addReportComment(@RequestBody AddReportCommentRec addReportCommentRec) {
        Integer userId = userService.getUserByName(addReportCommentRec.getReportorName());
        if (userId != null) {
            ReportComment reportComment = new ReportComment();
            reportComment.setReportId(userId);
            reportComment.setCommentId(addReportCommentRec.getCommentId());
            reportComment.setUserId(addReportCommentRec.getUserId());
            reportComment.setReportType(addReportCommentRec.getReportType());
            reportComment.setReason(addReportCommentRec.getReason());
            reportComment.setHandled(addReportCommentRec.getHandled());
            Timestamp timestamp = new Timestamp(addReportCommentRec.getTimeStamp().getTime());
            reportComment.setTimestamp(timestamp);
            return reportCommentService.addReportComment(reportComment);
        }
        return null;
    }

}
