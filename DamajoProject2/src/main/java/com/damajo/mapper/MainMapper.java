package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CpuVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

public interface MainMapper {
	
	@Select("SELECT cpu_no,cpu_name,company,price,poster FROM cpu_contents ORDER BY cpu_no ASC")
	public List<CpuVO> CPURecomList(Map map);	//메인 MD추천
	
	@Select("SELECT cpu_no,cpu_name,company,price,poster FROM cpu_contents ORDER BY cpu_no DESC")
	public List<CpuVO> CPUNewList(Map map);		//메인 신상품
	
	@Select("SELECT ssd_no,ssd_name,company,price,poster FROM ssd_contents ORDER BY ssd_no DESC")
	public List<SsdVO> SSDNewList(Map map);		//메인 신상품
	
	@Select("SELECT ssd_no,ssd_name,company,price,poster FROM ssd_contents ORDER BY ssd_no ASC")
	public List<SsdVO> SSDRecomList(Map map);	//메인 MD추천
	
	@Select("SELECT ram_no,ram_name, company,price,memory_capacity,poster FROM ram_contents ORDER BY ram_no DESC")
	public List<RamVO> RAMNewList(Map map);		//메인 신상품
	
	@Select("SELECT ram_no,ram_name, company,price,memory_capacity,poster FROM ram_contents ORDER BY ram_no ASC")
	public List<RamVO> RAMRecomList(Map map);	//메인 MD추천
	
	@Select("SELECT main_no,main_name,company,price,poster FROM main_contents ORDER BY main_no DESC")
	public List<MainVO> MainNewList(Map map);	//신상품

	@Select("SELECT main_no,main_name,company,price,poster FROM main_contents ORDER BY main_no ASC")
	public List<MainVO> MainRecomList(Map map);	//MD추천 
	
	@Select("SELECT vga_no,vga_name,poster,price,company FROM vga_contents ORDER BY vga_no DESC")
	public List<VgaVO> VgaNewList(Map map);		//신상

	@Select("SELECT vga_no,vga_name,poster,price,company FROM vga_contents ORDER BY vga_no ASC")
	public List<VgaVO> VgaRecomList(Map map);	//MD추천
	
	
	
	
	
}



















