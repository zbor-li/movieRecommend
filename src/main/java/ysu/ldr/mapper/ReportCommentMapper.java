package ysu.ldr.mapper;

import org.apache.ibatis.annotations.Param;
import ysu.ldr.pojo.ReportComment;

import java.util.List;

public interface ReportCommentMapper {

    public List<ReportComment> getAllReportComment(@Param("reportType") List<String> reportType);

    public List<ReportComment> getNoHandleReportComment(@Param("reportType") List<String> reportType);

    public Integer updateReportCommentStatusById(@Param("reportId") Integer reportId, @Param("reportCommentStatus") Boolean reportCommentStatus);

    public Integer deleteReportCommentById(@Param("reportId") Integer reportId);

    public Integer addReportComment(ReportComment reportComment);
}
