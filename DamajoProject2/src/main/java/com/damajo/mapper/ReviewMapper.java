package com.damajo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.damajo.vo.ReviewVO;

public interface ReviewMapper {
	//추가
	@Insert("INSERT INTO review VALUES((SELECT NVL(MAX(r_no)+1,1) FROM review),#{r_pno},#{id},#{r_subject},#{r_content},SYSDATE,#{category})")
	public void reviewInsert(ReviewVO vo);
	//리스트 
	@Select("SELECT r_no,r_pno,r_subject,r_content,today,id,num "
				+"FROM (SELECT r_no,r_pno,r_subject,r_content,TO_CHAR(r_regdate,'yyyy-MM-dd') as today,id,rownum as num "
				+"FROM (SELECT r_no,r_pno,r_subject,r_content,r_regdate,id "
				+"FROM review where r_pno=#{no} AND category=#{category} ORDER BY r_regdate DESC )) "
				+"WHERE num BETWEEN #{start} AND #{end}")
	public ReviewVO reviewList(int no,int category, int start, int end);
	// 총페이지
	@Select("SELECT COUNT(*) FROM review WHERE r_pno=#{no} AND category=#{category}")
	public int reviewTotal(int no,int category);
	// 삭제
	@Delete("DELETE FROM review WHERE r_no=${no}")
	public void reviewDelete(int no);
}
