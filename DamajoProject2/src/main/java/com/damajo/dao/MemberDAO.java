package com.damajo.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.MemberMapper;
import com.damajo.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;

	public int idCheck(MemberVO vo) {
		return mapper.idCheck(vo);
	}

	public int damajoSignupCheck(MemberVO vo) {
		return mapper.damajoSignupCheck(vo);
	}

	public int passwordCheck(MemberVO vo) {
		return mapper.passwordCheck(vo);
	}

	public void apiSignup(MemberVO vo) {
		mapper.apiSignup(vo);
	}

	public void damajoSignup(MemberVO vo) {
		mapper.damajoSignup(vo);
	}

	public int damajoIdCheck(MemberVO vo) {
		return mapper.damajoIdCheck(vo);
	}

	public String pwdSearch(MemberVO vo) {
		return mapper.pwdSearch(vo);
	}

	public void leaveAccount(MemberVO vo) {
		 mapper.leaveAccount(vo);
	}

	public MemberVO memberDetailInfo(MemberVO vo) {
		return mapper.memberDetailInfo(vo);
	}
	public void changePassword(MemberVO vo){
		mapper.changePassword(vo);
	}
}
