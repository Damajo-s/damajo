package com.damajo.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damajo.mapper.ContentsMapper;
import com.damajo.vo.CPUVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;

@Repository
public class ContentsDAO {
	@Autowired
	private ContentsMapper mapper;
	
	public List<CPUVO> cpuContentsList(Map map) {
		return mapper.cpuContentsList(map);
	}
	public int cpuTotalPage() {
		return mapper.cpuTotalPage();
	}
	
	public List<RAMVO> ramContentsList() {
		return mapper.ramContentsList();
	}
	
	public List<MAINVO> mainContentsList() {
		return mapper.mainContentsList();
	}
}
