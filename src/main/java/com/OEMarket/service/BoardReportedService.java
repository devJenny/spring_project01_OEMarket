package com.OEMarket.service;

import java.util.List;

import com.OEMarket.dto.ReportedDTO;

/* 
 * 게시물 신고
 * 2021. 12. 18.
 * Jenny (devje@naver.com)
 */

public interface BoardReportedService {
	public boolean registerBoardReported(ReportedDTO params);

	public ReportedDTO getBoardReportedDetail(Long reportedNo);

	public List<ReportedDTO> getBoardReportedList();
}
