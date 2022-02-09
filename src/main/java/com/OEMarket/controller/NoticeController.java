package com.OEMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OEMarket.dto.BoardDTO;
import com.OEMarket.service.NoticeService;

/* 
 * 공지사항
 * 2021. 12. 17.
 * Jenny (devje@naver.com)
 */

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;


	// 쓰기
	@GetMapping(value = "/notice/write.do")
	public String openNoticeWrite(@RequestParam(value = "boardNo", required = false) Long boardNo, Model model) {
		if (boardNo == null) {
			model.addAttribute("notice", new BoardDTO());
		} else {
			BoardDTO notice = noticeService.getNoticeDetail(boardNo);
			if (notice == null) {
				return "redirect:/notice/list.do";
			}
			model.addAttribute("notice", notice);
		}

		return "notice/write";
	}
	
	// 게시글 등록
	@PostMapping(value = "/notice/register.do")
	public String registerNotice(final BoardDTO params) {
		try {
			boolean isRegistered = noticeService.registerNotice(params);
			if (isRegistered == false) {
				// TODO => 게시글 등록에 실패하였다는 메시지를 전달
			}
		} catch (DataAccessException e) {
			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		} catch (Exception e) {
			// TODO => 시스템에 문제가 발생하였다는 메시지를 전달
		}

		return "redirect:/notice/list.do";
	}
	
	// 리스트
	@GetMapping(value = "/notice/list.do")
	public String openNoticeList(Model model) {
		List<BoardDTO> noticeList = noticeService.getNoticeList();
		model.addAttribute("noticeList", noticeList);

		return "notice/list";
	}
	
	// 게시글 조회
	@GetMapping(value = "/notice/view.do")
	public String openNoticeDetail(@RequestParam(value = "boardNo", required = false) Long boardNo, Model model) {
		if (boardNo == null) {
			// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/notice/list.do";
		}

		BoardDTO notice = noticeService.getNoticeDetail(boardNo);
		if (notice == null || "Y".equals(notice.getDeleteYn())) {
			// TODO => 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/notice/list.do";
		}
		model.addAttribute("notice", notice);

		return "notice/view";
	}
	
	// 삭제
	@PostMapping(value = "/notice/delete.do")
	public String deleteNotice(@RequestParam(value = "boardNo", required = false) Long boardNo) {
		if (boardNo == null) {
			// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:list.do";
		}

		try {
			boolean isDeleted = noticeService.deleteNotice(boardNo);
			if (isDeleted == false) {
				// TODO => 게시글 삭제에 실패하였다는 메시지를 전달
			}
		} catch (DataAccessException e) {
			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		} catch (Exception e) {
			// TODO => 시스템에 문제가 발생하였다는 메시지를 전달
		}

		return "redirect:list.do";
	}
}
