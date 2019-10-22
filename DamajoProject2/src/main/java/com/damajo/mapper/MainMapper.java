package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;
import com.damajo.vo.SSDVO;

public interface MainMapper {
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no ASC")
	public List<CPUVO> CPURecomList(Map map);
	
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no DESC")
	public List<CPUVO> CPUNewList(Map map);
	
	@Select("SELECT ssd_no,ssd_name,company,price FROM ssd_contents ORDER BY ssd_no DESC")
	public List<SSDVO> SSDNewList(Map map);
	
	@Select("SELECT ssd_no,ssd_name,company,price FROM ssd_contents ORDER BY ssd_no ASC")
	public List<SSDVO> SSDRecomList(Map map);
}
