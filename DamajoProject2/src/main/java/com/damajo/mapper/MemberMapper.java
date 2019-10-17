package com.damajo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.damajo.vo.MemberVO;

public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int idCheck(String id);
	
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id} AND type=#{type}")
	public int damajoSignupCheck(String id, int type);
	
	@Insert("INSERT INTO member VALUES ((SELECT NVL(MAX(no)+1,1)),#{id},'0000','0000',#{type})")
	public void apiSignup(String id,int type);
	
	@Insert("INSERT INTO member VALUES(#{id}, #{pwd}, #{hint}, #{type})")
	public void damajoSignup(MemberVO vo);
}
