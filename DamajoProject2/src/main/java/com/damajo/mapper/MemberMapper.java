package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int idCheck(String id);
	
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id} AND type=#{type}")
	public int damajoSignup(String id, int type);
}
