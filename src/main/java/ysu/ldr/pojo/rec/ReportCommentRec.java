package ysu.ldr.pojo.rec;

import java.util.Arrays;
import java.util.List;

public class ReportCommentRec {
    private List<String> query;
    private Boolean all;
    private Integer pageNum;
    private Integer pageSize;

    public ReportCommentRec(List<String> query, Boolean all, Integer pageNum, Integer pageSize) {
        this.query = query;
        this.all = all;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public ReportCommentRec() {
    }

    public List<String> getQuery() {
        return query;
    }

    public void setQuery(List<String> query) {
        this.query = query;
    }

    public Boolean getAll() {
        return all;
    }

    public void setAll(Boolean all) {
        this.all = all;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ReportCommentRec{" +
                "query=" + query +
                ", all=" + all +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
