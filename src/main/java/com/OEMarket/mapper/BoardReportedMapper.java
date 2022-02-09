package com.OEMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.ReportedDTO;

/* 
 * 게시물 신고
 * 2021. 12. 18.
 * Jenny (devje@naver.com)
 */

@Mapper
public interface BoardReportedMapper {
	public int insertBoardReported(ReportedDTO params);

	public ReportedDTO selectBoardReportedDetail(Long reportedNo);

	public int updateBoardReported(ReportedDTO params);


	public List<ReportedDTO> selectBoardReportedList();

	public int selectBoardReportedTotalCount();
}
