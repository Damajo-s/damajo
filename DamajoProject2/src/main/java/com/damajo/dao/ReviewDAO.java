package com.damajo.dao;

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
	public List<ReviewVO> reviewList(int no,int category,int start, int end){
		return mapper.reviewList(no,category,start,end);
	}
	//추가
	public void reviewInsert(ReviewVO vo){
		mapper.reviewInsert(vo);
	}
	// 총페이지
	public int reviewTotal(int no,int category){
		return mapper.reviewTotal(no, category);
	}
	//수정안할거야
	// 삭제
	public void reviewDelete(int no){
		mapper.reviewDelete(no);
	}
	
}
