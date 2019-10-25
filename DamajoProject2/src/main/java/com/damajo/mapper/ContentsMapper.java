package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CPUVO;
import com.damajo.vo.HDDVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;
import com.damajo.vo.SSDVO;
import com.damajo.vo.VGAVO;

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
	
	@Select("Select poster, ram_name, price, num "
			+ "From (Select poster, ram_name, price, rownum as num "
			+ "From (Select poster, ram_name, price "
			+ "From ram_contents Order By ram_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<RAMVO> ramContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From ram_contents")
	public int ramTotalPage();
	
	@Select("Select poster, main_name, price, num "
			+ "From (Select poster, main_name, price, rownum as num "
			+ "From (Select poster, main_name, price "
			+ "From main_contents Order By main_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<MAINVO> mainContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From main_contents")
	public int mainTotalPage();
	
	@Select("Select poster, vga_name, price, num "
			+ "From (Select poster, vga_name, price, rownum as num "
			+ "From (Select poster, vga_name, price "
			+ "From vga_contents Order By vga_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<VGAVO> vgaContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From vga_contents")
	public int vgaTotalPage();
	
	@Select("Select poster, ssd_name, price, num "
			+ "From (Select poster, ssd_name, price, rownum as num "
			+ "From (Select poster, ssd_name, price "
			+ "From ssd_contents Order By ssd_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<SSDVO> ssdContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From ssd_contents")
	public int ssdTotalPage();
	
	@Select("Select poster, hdd_name, price, num "
			+ "From (Select poster, hdd_name, price, rownum as num "
			+ "From (Select poster, hdd_name, price "
			+ "From hdd_contents Order By hdd_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<HDDVO> hddContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From hdd_contents")
	public int hddTotalPage();
}
