package com.OEMarket.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportedDTO extends CommentDTO {

	/* 신고 번호 (PK) */
	private Long reportedNo;
	
	/* 게시글 번호 */
	private Long boardNo;
	
	/* 회원번호 */
	private Long userNo;
	
	/* 신고 날짜 */
	private Date writeDate;
	
	/* 신고 내용 */
	private String content;
}
