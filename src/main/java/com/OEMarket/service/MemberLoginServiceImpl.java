package com.OEMarket.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.mapper.MemberLoginMapper;

@Service
public class MemberLoginServiceImpl implements MemberLoginService {

	@Autowired
	MemberLoginMapper memberLoginMapper;

	// 회원 로그인체크
	@Override
	public MemberDTO loginCheck(MemberDTO memberDTO) {
		return memberLoginMapper.loginCheck(memberDTO);
	}

	// 회원 로그인 정보
	@Override
	public MemberDTO viewMember(MemberDTO memberDTO) {
		return memberLoginMapper.viewMember(memberDTO);
	}

	// 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// 세션 변수개별 삭제
		// session.removeAttribute("email");
		// 세션 정보를 초기화시킴
		session.invalidate();
	}
}
