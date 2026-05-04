package ysu.ldr.service;

import ysu.ldr.pojo.ReportComment;

import java.util.List;

public interface ReportCommentService {
    public List<ReportComment> getAllReportComment(List<String> reportType);

    public List<ReportComment> getNoHandleReportComment(List<String> reportType);

    public Integer updateReportCommentStatusById(Integer reportId, Boolean reportCommentStatus);

    public Integer deleteReportCommentById(Integer reportId);

    public Integer addReportComment(ReportComment reportComment);
}
