package com.damajo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.damajo.vo.VideoBoardVO;

public interface VideoBoardMapper {
	//팁게시판 리스트
	@Select("SELECT no,title,writer,regdate,youtubekey,rownum as num "
			+ "FROM videoboard")// ORDER BY num ASC
	public List<VideoBoardVO> videoboard_list();
	// 팁게시판 조회수 증가
	@Update("UPDATE videoboard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	// 팁게시판 상세보기
	@Select("SELECT title,writer,regdate,hit,youtubekey "
			+ "FROM videoboard "
			+ "WHERE no=#{no}")
	public VideoBoardVO videoboard_detail(int no);
}
