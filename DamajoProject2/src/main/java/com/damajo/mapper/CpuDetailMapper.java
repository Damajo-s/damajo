package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CpuVO;

public interface CpuDetailMapper {
	 
	@Select("Select * From cpu_contents "
			+ "WHERE cpu_no=#{no}")
	public CpuVO CpuDetail(int no);
}
