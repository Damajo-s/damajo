package com.damajo.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damajo.mapper.ContentsMapper;
import com.damajo.vo.CPUVO;
import com.damajo.vo.HDDVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;
import com.damajo.vo.SSDVO;
import com.damajo.vo.VGAVO;

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
	
	public List<RAMVO> ramContentsList(Map map) {
		return mapper.ramContentsList(map);
	}
	public int ramTotalPage() {
		return mapper.ramTotalPage();
	}
	
	public List<MAINVO> mainContentsList(Map map) {
		return mapper.mainContentsList(map);
	}
	public int mainTotalPage() {
		return mapper.mainTotalPage();
	}
	
	public List<VGAVO> vgaContentsList(Map map) {
		return mapper.vgaContentsList(map);
	}
	public int vgaTotalPage() {
		return mapper.vgaTotalPage();
	}
	
	public List<SSDVO> ssdContentsList(Map map) {
		return mapper.ssdContentsList(map);
	}
	public int ssdTotalPage() {
		return mapper.ssdTotalPage();
	}
	
	public List<HDDVO> hddContentsList(Map map) {
		return mapper.hddContentsList(map);
	}
	public int hddTotalPage() {
		return mapper.hddTotalPage();
	}
}
