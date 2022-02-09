package com.OEMarket.service;

import javax.servlet.http.HttpSession;

import com.OEMarket.dto.MemberDTO;

public interface MemberLoginService {

	// 회원 로그인 체크
	public MemberDTO loginCheck(MemberDTO memberDTO);

	// 회원 로그인 정보
	public MemberDTO viewMember(MemberDTO memberDTO);

	// 회원 로그아웃
	public void logout(HttpSession session);
}
