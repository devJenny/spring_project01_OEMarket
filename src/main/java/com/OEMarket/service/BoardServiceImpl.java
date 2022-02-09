package com.OEMarket.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.mapper.BoardMapper;
import com.OEMarket.paging.PaginationInfo;

/* 
 * 게시판
 * 2021. 12. 14.
 * Jenny (devje@naver.com)
 */

@Service // 비즈니스 로직 담당하는 서비스 클래스
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;

		if (params.getBoardNo() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public BoardDTO getBoardDetail(Long boardNo) {
		return boardMapper.selectBoardDetail(boardNo);
	}

	@Override
	// 사용 중인 상태의 게시글인 경우에만 삭제
	public boolean deleteBoard(Long boardNo) {
		int queryResult = 0;

		BoardDTO board = boardMapper.selectBoardDetail(boardNo);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(boardNo);
		}

		return (queryResult == 1) ? true : false;
	}

	// 삭제되지 않은 전체 게시글 조회
	@Override
	public List<BoardDTO> getBoardList(BoardDTO params) {
		List<BoardDTO> boardList = Collections.emptyList();

		int boardTotalCount = boardMapper.selectBoardTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(boardTotalCount);
		
		params.setPaginationInfo(paginationInfo);

		if (boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList(params);
		}

		return boardList;
	}

}