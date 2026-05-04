package ysu.ldr.pojo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Timestamp;

public class ReportComment {
    private Integer reportId;
    private Integer commentId;
    private Integer userId;
    private String reason;
    private Timestamp timestamp;
    private Boolean handled;
    private Integer reportorId;
    private String reportType;

    public ReportComment() {
    }

    public ReportComment(Integer reportId, Integer commentId, Integer userId, String reason, Timestamp timestamp, Boolean handled, Integer reportorId, String reportType) {
        this.reportId = reportId;
        this.commentId = commentId;
        this.userId = userId;
        this.reason = reason;
        this.timestamp = timestamp;
        this.handled = handled;
        this.reportorId = reportorId;
        this.reportType = reportType;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getHandled() {
        return handled;
    }

    public void setHandled(Boolean handled) {
        this.handled = handled;
    }

    public Integer getReportorId() {
        return reportorId;
    }

    public void setReportorId(Integer reportorId) {
        this.reportorId = reportorId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Override
    public String toString() {
        return "ReportComment{" +
                "reportId=" + reportId +
                ", commentId=" + commentId +
                ", userId=" + userId +
                ", reason='" + reason + '\'' +
                ", timestamp=" + timestamp +
                ", handled=" + handled +
                ", reportorId=" + reportorId +
                ", reportType='" + reportType + '\'' +
                '}';
    }
}
