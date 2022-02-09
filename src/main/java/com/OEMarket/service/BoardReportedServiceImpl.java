package com.OEMarket.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.ReportedDTO;
import com.OEMarket.mapper.BoardReportedMapper;

/* 
 * 게시물 신고
 * 2021. 12. 18.
 * Jenny (devje@naver.com)
 */

@Service
public class BoardReportedServiceImpl implements BoardReportedService {

	@Autowired
	private BoardReportedMapper boardReportedMapper;

	@Override
	public boolean registerBoardReported(ReportedDTO params) {
		int queryResult = 0;

		if (params.getReportedNo() == null) {
			queryResult = boardReportedMapper.insertBoardReported(params);
		} else {
			queryResult = boardReportedMapper.updateBoardReported(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public ReportedDTO getBoardReportedDetail(Long reportedNo) {
		return boardReportedMapper.selectBoardReportedDetail(reportedNo);
	}


	@Override
	// 삭제되지 않은 전체 게시글 조회
	public List<ReportedDTO> getBoardReportedList() {
		List<ReportedDTO> boardReportedList = Collections.emptyList();

		int boardReportedTotalCount = boardReportedMapper.selectBoardReportedTotalCount();

		if (boardReportedTotalCount > 0) {
			boardReportedList = boardReportedMapper.selectBoardReportedList();
		}

		return boardReportedList;
	}
}
