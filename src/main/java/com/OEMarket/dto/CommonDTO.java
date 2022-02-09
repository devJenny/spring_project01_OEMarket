package com.OEMarket.dto;

import java.util.Date;

import com.OEMarket.paging.Criteria;
import com.OEMarket.paging.PaginationInfo;

import lombok.Getter;
import lombok.Setter;

/**
 * 2021-12-10
 * 공통컬럼을 묶기 위한 클래스 
 * @author 강경모
 */
@Getter
@Setter
public class CommonDTO extends Criteria {
	
	/* 페이징 정보 */
	private PaginationInfo paginationInfo;
	
	/* 등록일 */
	private Date writeDate;
	
	/* 수정자 */
	private String modifier;
	
	/* 수정일 */
	private Date modifyDate;
	
}
