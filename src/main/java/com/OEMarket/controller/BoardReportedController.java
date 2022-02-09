package com.OEMarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OEMarket.dto.ReportedDTO;
import com.OEMarket.service.BoardReportedService;

/* 
 * 게시물 신고
 * 2021. 12. 18.
 * Jenny (devje@naver.com)
 */


@Controller
public class BoardReportedController {
	@Autowired
	private BoardReportedService boardReportedService;
	

	// 쓰기
	@GetMapping(value = "/reported/boardReportedWrite.do")
	public String openBoardReportedWrite(@RequestParam(value = "reportedNo", required = false) Long reportedNo, Model model) {
		if (reportedNo == null) {
			model.addAttribute("boardReported", new ReportedDTO());
		} else {
			ReportedDTO boardReported = boardReportedService.getBoardReportedDetail(reportedNo);
			if (boardReported == null) {
				return "redirect:/reported/boardReportedview.do";
			}
			model.addAttribute("boardReported", boardReported);
		}

		return "reported/boardReportedWrite";
	}
	
	// 게시글 등록
	@PostMapping(value = "/reported/boardReportedRegister.do")
	public String registerBoardReported(final ReportedDTO params) {
		try {
			boolean isRegistered = boardReportedService.registerBoardReported(params);
			if (isRegistered == false) {
				// TODO => 게시글 등록에 실패하였다는 메시지를 전달
			}
		} catch (DataAccessException e) {
			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		} catch (Exception e) {
			// TODO => 시스템에 문제가 발생하였다는 메시지를 전달
		}

		 return "redirect:/reported/reportedAlert.do";
	
	}
		
		// 리스트
		@GetMapping(value = "/reported/boardReportedList.do")
		public String openBoardReportedList(Model model) {
			List<ReportedDTO> boardReportedList = boardReportedService.getBoardReportedList();
			model.addAttribute("boardReportedList", boardReportedList);

			return "reported/boardReportedList";
		}
		
		// 게시글 조회
		@GetMapping(value = "/reported/boardReportedview.do")
		public String openBoardReportedDetail(@RequestParam(value = "reportedNo", required = false) Long reportedNo, Model model) {
			if (reportedNo == null) {
				// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
				return "redirect:/reported/boardReportedList.do";
			}

			ReportedDTO boardReported = boardReportedService.getBoardReportedDetail(reportedNo);
			if (boardReported == null ) {
				// TODO => 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
				return "redirect:/boardReported/list.do";
			}
			model.addAttribute("boardReported", boardReported);

			return "reported/boardReportedview";
		} 
		
		// 신고 접수 확인
			@GetMapping(value ="/reported/reportedAlert.do" )
			public String boardReportedAlert() {
				return "reported/reportedAlert";
			}
		
}
