package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;

import java.util.*;

public interface ContentsMapper {
	@Select("Select poster, cpu_name, price, num "
			+ "From (Select poster, cpu_name, price, rownum as num "
			+ "From (Select poster, cpu_name, price "
			+ "From cpu_contents Order By cpu_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<CPUVO> cpuContentsList(Map map);
	
	@Select("Select Ceil(Count(*)/18) From cpu_contents")
	public int cpuTotalPage();
	
	@Select("Select poster, ram_name, price From ram_contents "
			+ "Order By ram_no ASC")
	public List<RAMVO> ramContentsList();
	
	@Select("Select poster, main_name, price From main_contents "
			+ "Order By main_no ASC")
	public List<MAINVO> mainContentsList();
}
