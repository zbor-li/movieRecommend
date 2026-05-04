package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.ReportCommentMapper;
import ysu.ldr.pojo.ReportComment;
import ysu.ldr.service.ReportCommentService;

import java.util.List;

@Service
public class ReportCommentServiceImpl implements ReportCommentService {

    @Autowired
    private ReportCommentMapper reportCommentMapper;

    @Override
    public List<ReportComment> getAllReportComment(List<String> reportType) {
//        System.out.println(reportType);
        return reportCommentMapper.getAllReportComment(reportType);
    }

    @Override
    public List<ReportComment> getNoHandleReportComment(List<String> reportType) {
        return reportCommentMapper.getNoHandleReportComment(reportType);
    }

    @Override
    public Integer updateReportCommentStatusById(Integer reportId, Boolean reportCommentStatus) {
        return reportCommentMapper.updateReportCommentStatusById(reportId, reportCommentStatus);
    }

    @Override
    public Integer deleteReportCommentById(Integer reportId) {
        return reportCommentMapper.deleteReportCommentById(reportId);
    }

    @Override
    public Integer addReportComment(ReportComment reportComment) {
        return reportCommentMapper.addReportComment(reportComment);
    }
}
