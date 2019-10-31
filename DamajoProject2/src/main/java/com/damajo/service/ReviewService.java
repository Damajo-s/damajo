package com.damajo.service;

import java.util.Date;
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
	public List<ReviewVO> reviewList(Map map){
		List<ReviewVO> rlist=rdao.reviewList(map);
		for(ReviewVO vo : rlist){
			int r_no = vo.getR_no();
			int r_pno = vo.getR_pno();
			String id = vo.getId();
			String r_subject = vo.getR_subject();
			String r_content = vo.getR_content();
			Date r_regdate = vo.getR_regdate();
			String today = vo.getToday();
			int category = vo.getCategory();
			System.out.println("r_no = " + r_no);
			vo.setR_no(r_no);
			vo.setR_pno(r_pno);
			vo.setId(id);
			vo.setR_subject(r_subject);
			vo.setR_content(r_content);
			vo.setR_regdate(r_regdate);
			vo.setToday(today);
			vo.setCategory(category);
		}
		return rlist;
	}
	// 총페이지
/*	public int reviewTotal(int no,int category){
		System.out.println("서비스"+no);
		System.out.println("서비스"+category);
		Map map = new HashMap();
		map.put("no", no);
		map.put("category", category);
		int total = rdao.reviewTotal();
		System.out.println("총초총"+total);
		return total;
	}*/
	public int reviewTotal(){
		return rdao.reviewTotal();
	}
	// 추가
	public void reviewInsert(ReviewVO vo){
		rdao.reviewInsert(vo);
	}
	// 삭제

}
