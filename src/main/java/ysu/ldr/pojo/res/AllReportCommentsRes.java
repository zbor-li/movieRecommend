package ysu.ldr.pojo.res;

import ysu.ldr.pojo.Comment;
import ysu.ldr.pojo.ReportComment;
import ysu.ldr.pojo.User;

import java.util.List;

public class AllReportCommentsRes {
    private List<CommentShowRow> commentShowRow;
    private Integer total;

    public AllReportCommentsRes() {
    }

    public AllReportCommentsRes(List<CommentShowRow> commentShowRow, Integer total) {
        this.commentShowRow = commentShowRow;
        this.total = total;
    }

    public List<CommentShowRow> getCommentShowRow() {
        return commentShowRow;
    }

    public void setCommentShowRow(List<CommentShowRow> commentShowRow) {
        this.commentShowRow = commentShowRow;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "AllReportCommentsRes{" +
                "commentShowRow=" + commentShowRow +
                ", total=" + total +
                '}';
    }
}
