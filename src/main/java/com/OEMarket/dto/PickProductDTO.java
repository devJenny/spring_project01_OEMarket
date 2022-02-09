package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PickProductDTO extends CommonDTO {

	/* 회원번호 */
	private Long userNo;
	
	/* 게시글 번호 */
	private Long boardNo;
	
}
