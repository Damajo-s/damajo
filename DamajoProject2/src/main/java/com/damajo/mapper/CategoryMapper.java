package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;
import com.damajo.vo.CategoryVO;
import java.util.*;

public interface CategoryMapper {
	
	// 카테고리 리스트 가져오기
	@Select("Select * From category")
	public List<CategoryVO> category();
	
	// CPU 제품 개수
	@Select("Select count(*) From cpu_contents")
	public int cpuTotalCount();
	// RAM 제품 개수
	@Select("Select count(*) From ram_contents")
	public int ramTotalCount();
	// MAIN 제품 개수
	@Select("Select count(*) From main_contents")
	public int mainTotalCount();
	// VGA 제품 개수
	@Select("Select count(*) From vga_contents")
	public int vgaTotalCount();
	// SSD 제품 개수
	@Select("Select count(*) From ssd_contents")
	public int ssdTotalCount();
	// HDD 제품 개수
	@Select("Select count(*) From hdd_contents")
	public int hddTotalCount();
	// POWER 제품 개수
	@Select("Select count(*) From power_contents")
	public int powerTotalCount();
}
