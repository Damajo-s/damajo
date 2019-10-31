package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.CompareMapper;
import com.damajo.vo.CompareVO;
import com.damajo.vo.OverseasVO;

@Repository
public class CompareDAO {
	@Autowired
	private CompareMapper mapper;

	public List<CompareVO> compare(Map map){
		return mapper.Compare(map);
	}

	public List<OverseasVO> overseascompare(Map map){
		return mapper.Overseas(map);
	}
}
