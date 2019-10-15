package com.damajo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damajo.mapper.VideoBoardMapper;
import com.damajo.vo.VideoBoardVO;

@Repository
public class VideoBoardDAO {
	@Autowired
	private VideoBoardMapper mapper;
	//팁게시판 리스트출력
	public List<VideoBoardVO> videoboard_list(){
		return mapper.videoboard_list(); 
	}
	//팁게시판 상세보기 출력
	public VideoBoardVO videoboard_detail(int no){
		mapper.hitIncrement(no);
		return mapper.videoboard_detail(no);
	}
}
