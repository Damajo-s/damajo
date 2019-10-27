package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

public interface ContentsMapper {
	@Select("Select cpu_no, poster, cpu_name, price, category, num "
			+ "From (Select cpu_no, poster, cpu_name, price, category, rownum as num "
			+ "From (Select cpu_no, poster, cpu_name, price, category "
			+ "From cpu_contents Order By cpu_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<CpuVO> cpuContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From cpu_contents")
	public int cpuTotalPage();

	@Select("Select ram_no, poster, ram_name, price, category, num "
			+ "From (Select ram_no, poster, ram_name, price, category, rownum as num "
			+ "From (Select ram_no, poster, ram_name, price, category "
			+ "From ram_contents Order By ram_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<RamVO> ramContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From ram_contents")
	public int ramTotalPage();

	@Select("Select main_no, poster, main_name, price, category, num "
			+ "From (Select main_no, poster, main_name, price, category, rownum as num "
			+ "From (Select main_no, poster, main_name, price, category "
			+ "From main_contents Order By main_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<MainVO> mainContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From main_contents")
	public int mainTotalPage();

	@Select("Select vga_no, poster, vga_name, price, category, num "
			+ "From (Select vga_no, poster, vga_name, price, category, rownum as num "
			+ "From (Select vga_no, poster, vga_name, price, category "
			+ "From vga_contents Order By vga_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<VgaVO> vgaContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From vga_contents")
	public int vgaTotalPage();

	@Select("Select ssd_no, poster, ssd_name, price, category, num "
			+ "From (Select ssd_no, poster, ssd_name, price, category, rownum as num "
			+ "From (Select ssd_no, poster, ssd_name, price, category "
			+ "From ssd_contents Order By ssd_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<SsdVO> ssdContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From ssd_contents")
	public int ssdTotalPage();

	@Select("Select hdd_no, poster, hdd_name, price, category, num "
			+ "From (Select hdd_no, poster, hdd_name, price, category, rownum as num "
			+ "From (Select hdd_no, poster, hdd_name, price, category "
			+ "From hdd_contents Order By hdd_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<HddVO> hddContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From hdd_contents")
	public int hddTotalPage();

	@Select("Select power_no, poster, power_name, price, category, num "
			+ "From (Select power_no, poster, power_name, price, category, rownum as num "
			+ "From (Select power_no, poster, power_name, price, category "
			+ "From power_contents Order By power_no asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<PowerVO> powerContentsList(Map map);
	@Select("Select Ceil(Count(*)/18) From power_contents")
	public int powerTotalPage();
}
