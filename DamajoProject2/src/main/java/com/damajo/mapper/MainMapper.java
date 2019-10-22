package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;

public interface MainMapper {
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no ASC")
	public List<CPUVO> CPURecomList(Map map);
	
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no DESC")
	public List<CPUVO> CPUNewList(Map map);
}
