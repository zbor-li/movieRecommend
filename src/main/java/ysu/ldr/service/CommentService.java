package ysu.ldr.service;

import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.recommend.DatTransf;
import ysu.ldr.pojo.res.CommentManageRes;

import java.util.List;


public interface CommentService {

    public Comment getCommentById(int commentId);

    public Integer getRatingByUserAndMovie(Integer userId, Integer movieId);

    public String getCommentByUserAndMovie(Integer userId, Integer movieId);

    public Integer addComment(Comment comment);

    public List<Comment> getCommentByMovieId(Integer movieId);

    public Integer deleteComment(Integer userId, Integer movieId);

    public List<CommentManageRes> searchCommentByContent(String searchContent);

    public List<CommentManageRes> searchCommentByUserName(String searchContent);

    public List<CommentManageRes> searchCommentByMovieName(String searchContent);

    public List<CommentManageRes> searchCommentByAll(String queryMessage);

    public Integer deleteCommentById(Integer commentId);

    public int getCommentByUserId(Integer userId);
    public List<DatTransf> getCommentToDat();
}
