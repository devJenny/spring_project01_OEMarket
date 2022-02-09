package com.OEMarket.service;

import com.OEMarket.dto.MemberDTO;

public interface MemberService {

	// 회원 가입
	public boolean registerMember(MemberDTO memberDTO);

	// 이메일 중복확인
	public int emailCheck(String email);

	// 닉네임 중복확인
	public int nickCheck(String nickname);

}
