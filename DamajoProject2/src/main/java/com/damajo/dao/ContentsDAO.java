package com.damajo.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.damajo.mapper.ContentsMapper;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Repository
public class ContentsDAO {
	@Autowired
	private ContentsMapper mapper;
	
	public List<CpuVO> cpuContentsList(Map map) {
		return mapper.cpuContentsList(map);
	}
	public int cpuTotalPage() {
		return mapper.cpuTotalPage();
	}
	
	public List<RamVO> ramContentsList(Map map) {
		return mapper.ramContentsList(map);
	}
	public int ramTotalPage() {
		return mapper.ramTotalPage();
	}
	
	public List<MainVO> mainContentsList(Map map) {
		return mapper.mainContentsList(map);
	}
	public int mainTotalPage() {
		return mapper.mainTotalPage();
	}
	
	public List<VgaVO> vgaContentsList(Map map) {
		return mapper.vgaContentsList(map);
	}
	public int vgaTotalPage() {
		return mapper.vgaTotalPage();
	}
	
	public List<SsdVO> ssdContentsList(Map map) {
		return mapper.ssdContentsList(map);
	}
	public int ssdTotalPage() {
		return mapper.ssdTotalPage();
	}
	
	public List<HddVO> hddContentsList(Map map) {
		return mapper.hddContentsList(map);
	}
	public int hddTotalPage() {
		return mapper.hddTotalPage();
	}
}
