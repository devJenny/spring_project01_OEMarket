package com.OEMarket.service;

import java.util.List;

import com.OEMarket.dto.BoardDTO;

/* 
 * 게시판
 * 2021. 12. 14.
 * Jenny (devje@naver.com)
 */

public interface BoardService {
	public boolean registerBoard(BoardDTO params);

	public BoardDTO getBoardDetail(Long boardNo);

	public boolean deleteBoard(Long boardNo);

	public List<BoardDTO> getBoardList(BoardDTO params);
}
