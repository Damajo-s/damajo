package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.CPUMapper;
import com.damajo.vo.CPUVO;

@Repository
public class CPUDAO {
	@Autowired
	private CPUMapper mapper;
	
	public List<CPUVO> CPUList(Map map){
		
		return mapper.CPUList(map);
	}
}
