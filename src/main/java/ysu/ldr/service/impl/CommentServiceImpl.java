package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.CommentMapper;
import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.recommend.DatTransf;
import ysu.ldr.pojo.res.CommentManageRes;
import ysu.ldr.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Comment getCommentById(int commentId) {
        return commentMapper.getCommentById(commentId);
    }

    @Override
    public Integer getRatingByUserAndMovie(Integer userId, Integer movieId) {
        return commentMapper.getRatingByUserAndMovie(userId, movieId);
    }

    @Override
    public String getCommentByUserAndMovie(Integer userId, Integer movieId) {
        return commentMapper.getCommentByUserAndMovie(userId, movieId);
    }

    @Override
    public Integer addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public List<Comment> getCommentByMovieId(Integer movieId) {
        return commentMapper.getCommentByMovieId(movieId);
    }

    @Override
    public Integer deleteComment(Integer userId, Integer movieId) {
        return commentMapper.deleteComment(userId, movieId);
    }

    @Override
    public List<CommentManageRes> searchCommentByContent(String searchContent) {
        return commentMapper.searchCommentByContent(searchContent);
    }

    @Override
    public List<CommentManageRes> searchCommentByUserName(String searchContent) {
        return commentMapper.searchCommentByUserName(searchContent);
    }

    @Override
    public List<CommentManageRes> searchCommentByMovieName(String searchContent) {
        return commentMapper.searchCommentByMovieName(searchContent);
    }

    @Override
    public List<CommentManageRes> searchCommentByAll(String queryMessage) {
        return commentMapper.searchCommentByAll(queryMessage);
    }

    @Override
    public Integer deleteCommentById(Integer commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

    @Override
    public int getCommentByUserId(Integer userId) {
        return commentMapper.getCommentByUserId(userId);
    }

    @Override
    public List<DatTransf> getCommentToDat() {
        return commentMapper.getCommentToDat();
    }
}
