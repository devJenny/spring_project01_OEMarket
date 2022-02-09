package com.OEMarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.OEMarket.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	// 회원 가입
	public int insertMember(MemberDTO memberDTO);

	// 이메일 중복 체크
	public int emailCheck(String email);

	// 닉네임 중복 체크
	public int nickCheck(String nickname);

}
