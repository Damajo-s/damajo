package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;

public interface CPUMapper {
	@Select("SELECT cpu_no,cpu_name,company,price FROM cpu_contents ORDER BY cpu_no DESC")
	public List<CPUVO> CPUList(Map map);
}
