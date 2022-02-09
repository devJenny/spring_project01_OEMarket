package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO extends CommonDTO {

	/* 사용자평가 번호 */
	private Long reviewNo;
	
	/* 게시글 번호 */
	private Long boardNo;
	
	/* 댓글 번호 */
	private Long commentNo;
	
	/* 점수 */
	private double rate;
	
	/* 작성자 */
	private String writer;
	
}
