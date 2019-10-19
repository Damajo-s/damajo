package com.damajo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.damajo.vo.MemberVO;

public interface MemberMapper {
	// 네이버 및 카카오로 로그인 시 가입되어 있는 ID가  있는지 체크
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int idCheck(String id);
	// 가입된 ID가 없다면 회원가입
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id} AND type=#{type}")
	public int damajoSignupCheck(String id, int type);
	
	@Insert("INSERT INTO member VALUES ((SELECT NVL(MAX(no)+1,1)),#{id},'0000','0000',#{type})")
	public void apiSignup(String id,int type);
	// 다마조 자체 회원가입
	@Insert("INSERT INTO member VALUES(#{id}, #{pwd}, #{hint}, #{type})")
	public void damajoSignup(MemberVO vo);
	
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int damajoIdCheck(String id);
	
	@Select("SELECT id,pwd FROM member WHERE id=#{id} AND hint=#{hint}")
	public String pwdSearch(String id, String hint);
	
	@Delete("DELECT FROM member where id=#{id}")
	public String leaveAccount(String id);
}
