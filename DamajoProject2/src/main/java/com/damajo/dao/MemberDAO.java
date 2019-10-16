package com.damajo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.MemberMapper;
@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public int idCheck(String id){
		return mapper.idCheck(id);
	}
	
	public int mysignup(String id, int type){
		return mapper.mysignup(id, type);
	}
}
