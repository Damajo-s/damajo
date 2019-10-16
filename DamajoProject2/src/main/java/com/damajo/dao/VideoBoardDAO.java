package com.damajo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damajo.vo.VideoBoardVO;

@Repository
public class VideoBoardDAO extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//팁게시판 리스트출력
	public List<VideoBoardVO> videoboard_list(){
		Map map=new HashMap();
		getSqlSession().update("videoboard_list",map);
		List<VideoBoardVO> list=(List<VideoBoardVO>)map.get("result");
		return list;
	}
	//팁게시판 상세보기 출력
	public VideoBoardVO videoboard_detail(int no){
		VideoBoardVO vo = new VideoBoardVO();
		Map map= new HashMap();
		map.put("no", no); 
		getSqlSession().update("videoboard_detail",map);
		List<VideoBoardVO> list =  (List<VideoBoardVO>) map.get("result");
		vo=list.get(0);
		return vo;
	}
}
