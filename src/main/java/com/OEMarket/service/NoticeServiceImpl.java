package com.OEMarket.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.mapper.NoticeMapper;

/* 
 * 공지사항
 * 2021. 12. 17.
 * Jenny (devje@naver.com)
 */

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public boolean registerNotice(BoardDTO params) {
		int queryResult = 0;

		if (params.getBoardNo() == null) {
			queryResult = noticeMapper.insertNotice(params);
		} else {
			queryResult = noticeMapper.updateNotice(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public BoardDTO getNoticeDetail(Long boardNo) {
		return noticeMapper.selectNoticeDetail(boardNo);
	}

	@Override
	// 사용 중인 상태의 게시글인 경우에만 삭제
	public boolean deleteNotice(Long boardNo) {
		int queryResult = 0;

		BoardDTO notice = noticeMapper.selectNoticeDetail(boardNo);

		if (notice != null && "N".equals(notice.getDeleteYn())) {
			queryResult = noticeMapper.deleteNotice(boardNo);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	// 삭제되지 않은 전체 게시글 조회
	public List<BoardDTO> getNoticeList() {
		List<BoardDTO> noticeList = Collections.emptyList();

		int noticeTotalCount = noticeMapper.selectNoticeTotalCount();

		if (noticeTotalCount > 0) {
			noticeList = noticeMapper.selectNoticeList();
		}

		return noticeList;
	}
}
