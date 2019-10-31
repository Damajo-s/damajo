package com.damajo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damajo.dao.ReviewDAO;
import com.damajo.vo.ReviewVO;

@Service
public class ReviewService {
	@Autowired
	private ReviewDAO rdao;
	// 리스트
	public List<ReviewVO> reviewList(int no,int category,int curPage){
		int rowSize = 5;
		int start = (curPage * rowSize) - (rowSize - 1); // 1
		int end = (curPage * rowSize); //5

		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<ReviewVO> rlist=rdao.reviewList(no,category,start,end);
		return rlist;
	}
	// 총페이지
	public int reviewTotal(int no,int category){
		System.out.println("서비스"+no);
		System.out.println("서비스"+category);
		int total = rdao.reviewTotal(no, category);
		System.out.println("총초총"+total);
		return total;
	}
	// 추가
	public void reviewInsert(ReviewVO vo){
		rdao.reviewInsert(vo);
	}
	// 삭제
	
}
