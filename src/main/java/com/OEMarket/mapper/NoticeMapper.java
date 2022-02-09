package com.OEMarket.mapper;

import java.util.List;

import com.OEMarket.dto.BoardDTO;

/* 
 * 공지사항
 * 2021. 12. 17.
 * Jenny (devje@naver.com)
 */

public interface NoticeMapper {
	public int insertNotice(BoardDTO params);

	public BoardDTO selectNoticeDetail(Long boardNo);

	public int updateNotice(BoardDTO params);

	public int deleteNotice(Long boardNo);

	public List<BoardDTO> selectNoticeList();

	public int selectNoticeTotalCount();

}
