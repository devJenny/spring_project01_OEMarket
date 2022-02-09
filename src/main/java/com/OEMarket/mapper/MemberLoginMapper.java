package com.OEMarket.mapper;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.MemberDTO;

@Mapper
public interface MemberLoginMapper {

	// 회원 로그인 체크
	public MemberDTO loginCheck(MemberDTO memberDTO);

	// 회원 로그인 정보
	public MemberDTO viewMember(MemberDTO memberDTO);

	// 회원 로그아웃
	public void logout(HttpSession session);
}
