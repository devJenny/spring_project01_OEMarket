package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO extends CommonDTO {
	
	/* 페이징 처리를 위한 번호 */
	private int rownum;
	
	/* 게시글 번호 */
	private Long boardNo;
	
	/* 작성자 */
	private Long userNo;
	
	/* 제목 */
	private String title;
	
	/* 카테고리 번호 */
	private Long categoryNo;
	
	/* 판매상태 */
	private String salesStatus;
	
	/* 판매금액 */
	private int price;
	
	/* 내용 */
	private String content;
	
	/* 조회수 */
	private int viewCount;
	
	/* 삭제여부 */
	private String deleteYn;
	
	/* 공지사항여부 */
	private String noticeYn;
	
	/* 유저정보 */
	private MemberDTO memberDTO;
	
	/* 첨부파일정보 */
	private AttachDTO attachDTO;
	
	private String saveName;
}
