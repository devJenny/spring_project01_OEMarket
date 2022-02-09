package com.OEMarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.BoardDTO;

/* 
 * 게시판
 * 2021. 12. 14.
 * Jenny (devje@naver.com)
 */

@Mapper
public interface BoardMapper {
	public int insertBoard(BoardDTO params);

	public BoardDTO selectBoardDetail(Long boardNo);

	public int updateBoard(BoardDTO params);

	public int deleteBoard(Long boardNo);

	public List<BoardDTO> selectBoardList(BoardDTO params);

	public int selectBoardTotalCount(BoardDTO params);
}




