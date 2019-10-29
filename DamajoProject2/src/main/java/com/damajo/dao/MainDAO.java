package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.MainMapper;
import com.damajo.vo.CpuVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Repository
public class MainDAO {
	@Autowired
	private MainMapper mapper;
	
	public List<CpuVO> CPURecomList(Map map){
		return mapper.CPURecomList(map);
	}
	
	public List<CpuVO> CPUNewList(Map map){
		return mapper.CPUNewList(map);
	}
	
	public List<SsdVO> SSDNewList(Map map){
		return mapper.SSDNewList(map);
	}
	
	public List<SsdVO> SSDRecomList(Map map){
		return mapper.SSDRecomList(map);
	}
	
	public List<RamVO> RAMNewList(Map map){
		return mapper.RAMNewList(map);
	}
	
	public List<RamVO> RAMRecomList(Map map){
		return mapper.RAMRecomList(map);
	}
	
	public List<MainVO> MainNewList(Map map){
		return mapper.MainNewList(map);
	}
	
	public List<MainVO> MainRecomList(Map map){
		return mapper.MainRecomList(map);
	}
	
	public List<VgaVO> VgaNewList(Map map){
		return mapper.VgaNewList(map);
	}
	
	public List<VgaVO> VgaRecomList(Map map){
		return mapper.VgaRecomList(map);
	}
	
	
	
	
	
	
}
