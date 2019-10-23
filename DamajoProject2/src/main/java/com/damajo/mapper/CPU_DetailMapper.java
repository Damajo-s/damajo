package com.damajo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;

public interface CPU_DetailMapper {
	
	@Select("Select * From cpu_contents "
			+ "WHERE cpu_no=#{no}")
	public CPUVO CPU_Detail(int no);
}
