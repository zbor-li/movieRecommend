package ysu.ldr.pojo.rec;

import java.util.Date;

public class AddReportCommentRec {
    private Integer commentId;
    private Integer userId;
    private String reportorName;
    private String reason;
    private Date timeStamp;
    private Boolean handled;
    private String reportType;

    public AddReportCommentRec() {
    }

    public AddReportCommentRec(Integer commentId, Integer userId, String reportorName, String reason, Date timeStamp, Boolean handled, String reportType) {
        this.commentId = commentId;
        this.userId = userId;
        this.reportorName = reportorName;
        this.reason = reason;
        this.timeStamp = timeStamp;
        this.handled = handled;
        this.reportType = reportType;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReportorName() {
        return reportorName;
    }

    public void setReportorName(String reportorName) {
        this.reportorName = reportorName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getHandled() {
        return handled;
    }

    public void setHandled(Boolean handled) {
        this.handled = handled;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Override
    public String toString() {
        return "AddReportCommentRec{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", reportorName='" + reportorName + '\'' +
                ", reason='" + reason + '\'' +
                ", timeStamp=" + timeStamp +
                ", handled=" + handled +
                ", reportType='" + reportType + '\'' +
                '}';
    }
}
