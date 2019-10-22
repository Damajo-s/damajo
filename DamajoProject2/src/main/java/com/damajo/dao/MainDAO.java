package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.MainMapper;
import com.damajo.vo.CPUVO;
import com.damajo.vo.SSDVO;

@Repository
public class MainDAO {
	@Autowired
	private MainMapper mapper;
	
	public List<CPUVO> CPURecomList(Map map){
		
		return mapper.CPURecomList(map);
	}
	
	public List<CPUVO> CPUNewList(Map map){
		return mapper.CPUNewList(map);
	}
	
	public List<SSDVO> SSDNewList(Map map){
		return mapper.SSDNewList(map);
	}
	
	public List<SSDVO> SSDRecomList(Map map){
		return mapper.SSDRecomList(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
