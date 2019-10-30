package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.damajo.vo.MemberVO;
import com.damajo.vo.QABoardVO;

public interface MemberMapper {
	// 네이버 및 카카오로 로그인 시 가입되어 있는 ID가 있는지 체크
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int idCheck(MemberVO vo);

	// 가입된 ID가 없다면 회원가입
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id} AND type=#{type}")
	public int damajoSignupCheck(MemberVO vo);

	@Select("SELECT COUNT(*) FROM member WHERE id=#{id} AND pwd = #{pwd} AND type = #{type}")
	public int passwordCheck(MemberVO vo);

	@Insert("INSERT INTO member VALUES ((SELECT NVL(MAX(no)+1,1) FROM member),#{id},'0000','0000',#{type},'0000')")
	public void apiSignup(MemberVO vo);

	// 다마조 자체 회원가입
	@Insert("INSERT INTO member VALUES((SELECT NVL(MAX(no)+1,1) FROM member),#{id}, #{pwd}, #{hint}, #{type},#{hint_answer})")
	public void damajoSignup(MemberVO vo);

	// 아이디 존재 확인
	@Select("SELECT COUNT(*) FROM member WHERE id=#{id}")
	public int damajoIdCheck(MemberVO vo);

	// 비밀번호 힌트로 조회후 변경
	@Select("SELECT id,pwd FROM member WHERE id=#{id} AND hint=#{hint}")
	public String pwdSearch(MemberVO vo);

	@Select("SELECT * FROM member WHERE id=#{id}")
	public MemberVO memberDetailInfo(MemberVO vo);

	@Update("UPDATE member SET pwd = #{pwd} WHERE id = #{id}")
	public void changePassword(MemberVO vo);

	@Delete("DELETE FROM member where id=#{id}")
	public void leaveAccount(MemberVO vo);

	// admin 계정 회원정보리스트
	@Select("SELECT no,id,type,num FROM (SELECT  no,id,type,rownum as num  FROM (SELECT no,id,type FROM member ORDER BY no desc )) WHERE num BETWEEN #{start} AND #{end}")
	public List<MemberVO> userList(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/5.0) FROM qaboard WHERE id=#{id}")
	public int qnaTotalPage(QABoardVO vo);
	@Select("SELECT CEIL(COUNT(*)/5.0) FROM member")
	public int adminMemberPageCount();
}
