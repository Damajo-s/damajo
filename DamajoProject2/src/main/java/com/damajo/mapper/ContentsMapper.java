package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

import java.util.*;

public interface ContentsMapper {
	@Select("Select poster, cpu_name, price, num "
			+ "From (Select poster, cpu_name, price, rownum as num "
			+ "From (Select poster, cpu_name, price "
			+ "From cpu_contents Order By cpu_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<CpuVO> cpuContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From cpu_contents")
	public int cpuTotalPage();
	
	@Select("Select poster, ram_name, price, num "
			+ "From (Select poster, ram_name, price, rownum as num "
			+ "From (Select poster, ram_name, price "
			+ "From ram_contents Order By ram_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<RamVO> ramContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From ram_contents")
	public int ramTotalPage();
	
	@Select("Select poster, main_name, price, num "
			+ "From (Select poster, main_name, price, rownum as num "
			+ "From (Select poster, main_name, price "
			+ "From main_contents Order By main_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<MainVO> mainContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From main_contents")
	public int mainTotalPage();
	
	@Select("Select poster, vga_name, price, num "
			+ "From (Select poster, vga_name, price, rownum as num "
			+ "From (Select poster, vga_name, price "
			+ "From vga_contents Order By vga_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<VgaVO> vgaContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From vga_contents")
	public int vgaTotalPage();
	
	@Select("Select poster, ssd_name, price, num "
			+ "From (Select poster, ssd_name, price, rownum as num "
			+ "From (Select poster, ssd_name, price "
			+ "From ssd_contents Order By ssd_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<SsdVO> ssdContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From ssd_contents")
	public int ssdTotalPage();
	
	@Select("Select poster, hdd_name, price, num "
			+ "From (Select poster, hdd_name, price, rownum as num "
			+ "From (Select poster, hdd_name, price "
			+ "From hdd_contents Order By hdd_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<HddVO> hddContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From hdd_contents")
	public int hddTotalPage();
	
	@Select("Select poster, power_name, price, num "
			+ "From (Select poster, power_name, price, rownum as num "
			+ "From (Select poster, power_name, price "
			+ "From power_contents Order By power_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<PowerVO> powerContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From power_contents")
	public int powerTotalPage();
}
