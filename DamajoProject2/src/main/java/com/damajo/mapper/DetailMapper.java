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

public interface DetailMapper {

	@Select("Select * From cpu_contents "
			+ "WHERE cpu_no = #{no} and category = #{category}")
	public List<CpuVO> CpuDetail(Map map);

	@Select("Select * From ram_contents "
			+ "WHERE ram_no = #{no}")
	public List<RamVO> RamDetail(Map map);

	@Select("Select * From main_contents "
			+ "WHERE main_no = #{no}")
	public List<MainVO> MainDetail(Map map);

	@Select("Select * From vga_contents "
			+ "WHERE vga_no = #{no}")
	public List<VgaVO> VgaDetail(Map map);

	@Select("Select * From ssd_contents "
			+ "WHERE ssd_no = #{no}")
	public List<SsdVO> SsdDetail(Map map);

	@Select("Select * From hdd_contents "
			+ "WHERE hdd_no = #{no}")
	public List<HddVO> HddDetail(Map map);

	@Select("Select * From power_contents "
			+ "WHERE power_no = #{no}")
	public List<PowerVO> PowerDetail(Map map);

}
