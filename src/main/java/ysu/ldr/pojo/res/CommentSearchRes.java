package ysu.ldr.pojo.res;

import java.util.List;

public class CommentSearchRes {
    private List<CommentManageRes> commentManageResList;
    private Integer total;

    public CommentSearchRes() {
    }

    public CommentSearchRes(List<CommentManageRes> commentManageResList, Integer total) {
        this.commentManageResList = commentManageResList;
        this.total = total;
    }

    public List<CommentManageRes> getCommentManageResList() {
        return commentManageResList;
    }

    public void setCommentManageResList(List<CommentManageRes> commentManageResList) {
        this.commentManageResList = commentManageResList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CommentSearchRes{" +
                "commentManageResList=" + commentManageResList +
                ", total=" + total +
                '}';
    }
}
