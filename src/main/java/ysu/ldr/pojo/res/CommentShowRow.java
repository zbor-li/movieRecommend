package ysu.ldr.pojo.res;

public class CommentShowRow {
    private Integer reportId;
    private Integer commentId;
    private String content;
    private String userName;
    private Integer userId;
    private Boolean userStatus;
    private String reportorName;
    private Integer reportorId;
    private Boolean reportorStatus;
    private String reason;
    private String reportType;
    private Boolean reportCommentStatus;

    public CommentShowRow() {
    }

    public CommentShowRow(Integer reportId, Integer commentId, String content, String userName, Integer userId, Boolean userStatus, String reportorName, Integer reportorId, Boolean reportorStatus, String reason, String reportType, Boolean reportCommentStatus) {
        this.reportId = reportId;
        this.commentId = commentId;
        this.content = content;
        this.userName = userName;
        this.userId = userId;
        this.userStatus = userStatus;
        this.reportorName = reportorName;
        this.reportorId = reportorId;
        this.reportorStatus = reportorStatus;
        this.reason = reason;
        this.reportType = reportType;
        this.reportCommentStatus = reportCommentStatus;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getReportorName() {
        return reportorName;
    }

    public void setReportorName(String reportorName) {
        this.reportorName = reportorName;
    }

    public Integer getReportorId() {
        return reportorId;
    }

    public void setReportorId(Integer reportorId) {
        this.reportorId = reportorId;
    }

    public Boolean getReportorStatus() {
        return reportorStatus;
    }

    public void setReportorStatus(Boolean reportorStatus) {
        this.reportorStatus = reportorStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Boolean getReportCommentStatus() {
        return reportCommentStatus;
    }

    public void setReportCommentStatus(Boolean reportCommentStatus) {
        this.reportCommentStatus = reportCommentStatus;
    }

    @Override
    public String toString() {
        return "CommentShowRow{" +
                "reportId=" + reportId +
                ", commentId=" + commentId +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", userStatus=" + userStatus +
                ", reportorName='" + reportorName + '\'' +
                ", reportorId=" + reportorId +
                ", reportorStatus=" + reportorStatus +
                ", reason='" + reason + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportCommentStatus=" + reportCommentStatus +
                '}';
    }
}
