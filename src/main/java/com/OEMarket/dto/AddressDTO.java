package com.OEMarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO extends CommonDTO {

	/* 배송지 번호(PK) */
	private Long addressNo;
	
	/* 회원번호 */
	private Long userNo;
	
	/* 우편번호 */
	private String postalCode;
	
	/* 상세주소 */	
	private String detailAddress;
}
