package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachDTO {

	/* 첨부파일 번호 */
	private Long attachNo;
	
	/* 게시글 번호 */
	private Long boardNo;
	
	/* 원본 파일명 */
	private String originalName;
	
	/* 저장 파일명 */
	private String saveName;
	
	/* 크기 */
	private long size;
	
	/* 삭제여부 */
	private String deleteYn;
	
}
