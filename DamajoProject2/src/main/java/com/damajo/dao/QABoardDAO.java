package com.damajo.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.vo.QABoardVO;

@Repository
public class QABoardDAO extends SqlSessionDaoSupport {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	// 추가
	public void qaboardInsert(QABoardVO vo){
		Map map=new HashMap();
		map.put("pno", vo.getPno());
		map.put("subject", vo.getSubject());
		map.put("content", vo.getContent());
		map.put("id", vo.getId());
		map.put("pwd", vo.getPwd());
		map.put("adminres", vo.getAdminres());
		getSqlSession().update("qaboardInsert",map);
	}
	// 리스트출력
	public List<QABoardVO> qaboardList(int page){
		// 페이지 지정
		List<QABoardVO> list=new ArrayList<QABoardVO>();
		int rowSize=10;
		int qstart=(page*rowSize)-(rowSize-1); //1
		int qend=(page*rowSize); //10
		
		Map map=new HashMap();
		map.put("qstart", qstart);
		map.put("qend", qend);
		
		getSqlSession().update("qaboardList",map);
		list=(List<QABoardVO>)map.get("result");
		return list;
	}
	//총페이지
	public int qaboardTotal(){
		Map map=new HashMap();
		getSqlSession().update("qaboardTotal",map);
		int total=(Integer)map.get("qtotal");
		return total;
	}
	
	
	
	
	
	
}
