package com.OEMarket.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MemberDTO {

	/* 회원번호 */
	private Long userNo;

	/* 이메일 */
	@NotBlank(message = "이메일은 필수 입력값입니다.")
	@Email
	private String email;

	/* 비밀번호 */
	@NotBlank(message = "비밀번호는 필수 입력값입니다.")
	private String password;

	/* 이름 */
	@NotBlank(message = "이름은 필수 입력값입니다.")
	private String name;

	/* 닉네임 */
	@NotBlank(message = "닉네임은 필수 입력값입니다.")
	private String nickname;

	/* 성별 */
	private String gender;

	/* 전화번호 */
	@NotBlank(message = "전화번호는 필수 입력값입니다.")
	private String phone;

	/* 회원 아이콘 */
	private String userIcon;

	/* 회원 가입일 */
	private String signup_date;

	/* 회원 탈퇴여부 */
	private String signout_yn;

	/* 회원 탈퇴일 */
	private String signout_date;

	/* 회원 구분 */
	private String memberRole;

}
