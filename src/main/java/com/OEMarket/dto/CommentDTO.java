package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO extends CommonDTO{

	/* 댓글 번호 */
	private Long commentNo;
	
	/* 게시글 번호 */
	private Long boardNo;
	
	/* 작성자 */
	private Long userNo;
	
	/* 비밀댓글 여부 */
	private String secretYn;
	
	/* 내용 */
	private String content;
	
	/* 부모댓글 */
	private Long parent;
	
	/* 대댓글 여부 */
	private int depth;
	
	/* 삭제여부 */
	private String deleteYn;
	
	/* 유저정보 */
	private MemberDTO memberDTO;
	
}
