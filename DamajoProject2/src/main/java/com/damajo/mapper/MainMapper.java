package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;
import com.damajo.vo.RAMVO;
import com.damajo.vo.SSDVO;

public interface MainMapper {
	
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no ASC")
	public List<CPUVO> CPURecomList(Map map);	//메인 MD추천
	
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no DESC")
	public List<CPUVO> CPUNewList(Map map);		//메인 신상품
	
	@Select("SELECT ssd_no,ssd_name,company,price FROM ssd_contents ORDER BY ssd_no DESC")
	public List<SSDVO> SSDNewList(Map map);		//메인 신상품
	
	@Select("SELECT ssd_no,ssd_name,company,price FROM ssd_contents ORDER BY ssd_no ASC")
	public List<SSDVO> SSDRecomList(Map map);	//메인 MD추천
	
	@Select("SELECT ram_no,ram_name, company,price,memory_capacity FROM ram_contents ORDER BY ram_no DESC")
	public List<RAMVO> RAMNewList(Map map);		//메인 신상품
	
	@Select("SELECT ram_no,ram_name, company,price,memory_capacity FROM ram_contents ORDER BY ram_no ASC")
	public List<RAMVO> RAMRecomList(Map map);	//메인 MD추천
	
	
	
	
	
	
	
	
	
	
	
}



















