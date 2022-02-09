package com.OEMarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	// 회원 가입
	@Override
	public boolean registerMember(MemberDTO memberDTO) {

		int queryResult = 0;
		if (memberDTO.getUserNo() == null) {
			queryResult = memberMapper.insertMember(memberDTO);
		} else {
			queryResult = 0;
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public int emailCheck(String email) {
		int result = memberMapper.emailCheck(email);
		return result;
	}

	@Override
	public int nickCheck(String nickname) {
		int result = memberMapper.nickCheck(nickname);
		return result;
	}

}
