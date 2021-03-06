package com.damajo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.vo.QABoardVO;

@Repository
public class QABoardDAO extends SqlSessionDaoSupport {
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// 추가
	public void qaboardInsert(QABoardVO vo) {
		Map map = new HashMap();
		map.put("pno", vo.getPno());
		map.put("id", vo.getId());
		map.put("subject", vo.getSubject());
		map.put("content", vo.getContent());
		map.put("adminres", vo.getAdminres());
		map.put("category", vo.getCategory());
		map.put("admintype", vo.getAdmintype());
		getSqlSession().update("qaboardInsert", map);
	}

	// 리스트출력
	public List<QABoardVO> qaboardList(int page, int no,int category) {
		// 페이지 지정
		int rowSize = 5;
		int qstart = (page * rowSize) - (rowSize - 1); // 1
		int qend = (page * rowSize); //5

		Map map = new HashMap();
		map.put("qstart", qstart);
		map.put("qend", qend);
		map.put("qpno", no);
		map.put("qcategory", category);

		getSqlSession().update("qaboardList",map);
		List<QABoardVO> list= (List<QABoardVO>)map.get("result");

		return list;
	}
	// 해당 상품게시물 수
	public int qaboardPnoCount(int no,int category){
		Map map=new HashMap();
		map.put("qpno", no);
		map.put("qcategory", category);
		getSqlSession().update("qaboardPnoCount",map);
		int qCpno =(int)map.get("qCpno");
		return qCpno;
	}
	
	// 내 qna 리스트
	public List<QABoardVO> myqaboardList(int page, String id) {
		// 페이지 지정
		int rowSize =5;
		int qstart = (page * rowSize) - (rowSize - 1); // 1
		int qend = (page * rowSize); // 10
		String qpno = id;
		Map map = new HashMap();
		map.put("qstart", qstart);
		map.put("qend", qend);
		map.put("qpno", qpno);

		getSqlSession().update("myqaboardList", map);
		List<QABoardVO> list = (List<QABoardVO>) map.get("result");
		return list;
	}
	// 총페이지
	public int qaboardTotal(int no,int category) {
		int qpno=no;
		int qcategory=category;
		Map map = new HashMap();
		map.put("qpno", qpno);
		map.put("qcategory", qcategory);
		getSqlSession().update("qaboardTotal", map);
		int total = (Integer) map.get("qtotal");
		return total;
	}
	// 답변대기 총 수 
	public int adminwaitCount(int no,int category){
		Map map = new HashMap();
		map.put("qpno", no);
		map.put("qcategory", category);
		getSqlSession().update("adminwaitCount",map);
		int adminwait = (Integer)map.get("adminwait");
		return adminwait;
	}
	// 답변완료 총 수
	
	
	// 관리자 답변 수정
	public void adminupdate(QABoardVO vo){
		Map map = new HashMap();
		map.put("qpno", vo.getPno());
		map.put("qcategory", vo.getCategory());
		map.put("qadmintype", vo.getAdmintype());
		map.put("admincontent", vo.getAdminres());
		System.out.println("ggggggg"+vo.getAdminres());
		getSqlSession().update("adminupdate",map);
	}
	
	public int myqaboardTotal(String id) {
		Map map = new HashMap();
		map.put("qid",id);
		getSqlSession().update("myqaboardTotal", map);
		int total = (Integer) map.get("qtotal");
		return total;
	}
}
