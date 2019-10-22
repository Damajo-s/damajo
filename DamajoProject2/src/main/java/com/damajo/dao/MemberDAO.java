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

	public String pwdSearch(String id, String hint) {
		return mapper.pwdSearch(id, hint);
	}

	public String leaveAccount(String id) {
		return mapper.leaveAccount(id);
	}

}
