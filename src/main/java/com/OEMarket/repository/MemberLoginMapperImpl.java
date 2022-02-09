package com.OEMarket.repository;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.OEMarket.dto.MemberDTO;
import com.OEMarket.mapper.MemberLoginMapper;

@Repository
public class MemberLoginMapperImpl implements MemberLoginMapper {

	@Inject
	SqlSession sqlSession;

	@Override
	public MemberDTO loginCheck(MemberDTO memberDTO) {
		return sqlSession.selectOne("login", memberDTO);
	}

	@Override
	public MemberDTO viewMember(MemberDTO memberDTO) {
		return sqlSession.selectOne("member.viewMember", memberDTO);
	}

	@Override
	public void logout(HttpSession session) {

	}

}
