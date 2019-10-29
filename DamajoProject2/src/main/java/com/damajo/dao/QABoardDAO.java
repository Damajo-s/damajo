package com.damajo.dao;

import java.text.SimpleDateFormat;
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
		map.put("id", vo.getId());
		map.put("subject", vo.getSubject());
		map.put("content", vo.getContent());
		map.put("adminres", vo.getAdminres());
		getSqlSession().update("qaboardInsert",map);
	}
	// 리스트출력
	public List<QABoardVO> qaboardList(int page,int product){
		// 페이지 지정
		int rowSize=5;
		int qstart=(page*rowSize)-(rowSize-1); //1
		int qend=(page*rowSize); //10
		int qpno=product;

		Map map=new HashMap();
		map.put("qstart", qstart);
		map.put("qend", qend);
		map.put("qpno", qpno);
		
		getSqlSession().update("qaboardList",map);
		List<QABoardVO> list= (List<QABoardVO>)map.get("result");
		return list;
	}
	// 해당 상품게시물 수
	public int qaboardPnoCount(int product){
		int qpno=product;
		Map map=new HashMap();
		map.put("qpno", qpno);
		getSqlSession().update("qaboardPnoCount",map);
		int qCpno =(int)map.get("qCpno");
		return qCpno;
	}
	//총페이지
	public int qaboardTotal(){
		Map map=new HashMap();
		getSqlSession().update("qaboardTotal",map);
		int total=(Integer)map.get("qtotal");
		return total;
	}
	
	
	
	
	
	
}
