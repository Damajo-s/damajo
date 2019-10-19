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
	
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}
	
	public int damajoSignupCheck(String id, int type) {
		return mapper.damajoSignupCheck(id, type);
	}
	
	public void apiSignup(String id,int type){
		mapper.apiSignup(id, type);
	}
	
	public void damajoSignup(MemberVO vo){
		mapper.damajoSignup(vo);
	}

	public int damajoIdCheck(String id) {
		return mapper.damajoIdCheck(id);
	}
	
	public String pwdSearch(String id, String hint) {
		return mapper.pwdSearch(id, hint);
	}
	
	public String leaveAccount(String id){
		return mapper.leaveAccount(id);
	}
	
	
}
