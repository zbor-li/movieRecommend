package ysu.ldr.mapper;

import org.apache.ibatis.annotations.Param;
import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.recommend.DatTransf;
import ysu.ldr.pojo.res.CommentManageRes;

import java.util.List;

public interface CommentMapper {

    public Comment getCommentById(@Param("commentId")int commentId);

    public Integer getRatingByUserAndMovie(@Param("userId") Integer userId, @Param("movieId") Integer movieId);

    public String getCommentByUserAndMovie(@Param("userId") Integer userId, @Param("movieId") Integer movieId);

    public Integer addComment(Comment comment);

    public List<Comment> getCommentByMovieId(@Param("movieId") Integer movieId);

    public Integer deleteComment(@Param("userId")Integer userId, @Param("movieId") Integer movieId);

    public List<CommentManageRes> searchCommentByContent(String searchContent);

    public List<CommentManageRes> searchCommentByUserName(String searchContent);

    public List<CommentManageRes> searchCommentByMovieName(String searchContent);

    public List<CommentManageRes> searchCommentByAll(String queryMessage);

    public Integer deleteCommentById(Integer commentId);

    public int getCommentByUserId(Integer userId);
    public List<DatTransf> getCommentToDat();
}
