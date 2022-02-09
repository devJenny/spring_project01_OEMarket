package com.OEMarket.service;

import java.util.List;

import com.OEMarket.dto.BoardDTO;

/* 
 * 공지사항
 * 2021. 12. 17.
 * Jenny (devje@naver.com)
 */

public interface NoticeService {
	public boolean registerNotice(BoardDTO params);

	public BoardDTO getNoticeDetail(Long boardNo);

	public boolean deleteNotice(Long boardNo);

	public List<BoardDTO> getNoticeList();
}
