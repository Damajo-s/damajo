package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.ReviewMapper;
import com.damajo.vo.ReviewVO;

@Repository
public class ReviewDAO {
	@Autowired
	private ReviewMapper mapper;
	//리스트
	public List<ReviewVO> reviewList(Map map){
		return mapper.reviewList(map);
	}
	//추가
	public void reviewInsert(ReviewVO vo){
		mapper.reviewInsert(vo);
	}
	// 총페이지
	public int reviewTotal(){
		return mapper.reviewTotal();
	}
	//수정안할거야
	// 삭제
	public void reviewDelete(int no){
		mapper.reviewDelete(no);
	}

}
