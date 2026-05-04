package ysu.ldr.pojo.rec;

public class CommentSearchRec {
    private Integer query;
    private String queryMessage;
    private Integer pageNum;
    private Integer pageSize;

    public CommentSearchRec() {
    }

    public CommentSearchRec(Integer query, String queryMessage, Integer pageNum, Integer pageSize) {
        this.query = query;
        this.queryMessage = queryMessage;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getQuery() {
        return query;
    }

    public void setQuery(Integer query) {
        this.query = query;
    }

    public String getQueryMessage() {
        return queryMessage;
    }

    public void setQueryMessage(String queryMessage) {
        this.queryMessage = queryMessage;
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
        return "CommentSearchRec{" +
                "query=" + query +
                ", queryMessage='" + queryMessage + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
