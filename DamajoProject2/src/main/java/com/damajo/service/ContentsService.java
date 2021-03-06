package com.damajo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.ContentsDAO;
import com.damajo.dao.SearchDataDAO;
import com.damajo.mvc.ContentsController;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.ProductVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Service
public class ContentsService {
	@Autowired
	private ContentsDAO dao;
	@Autowired
	private SearchDataDAO searchDao;
	@Autowired
	private ContentsController contents;
	
	public List<ProductVO> searchAllDataList(Map map) {
		return searchDao.searchAllDataList(map);
	}
	public int searchAllDataTotalPage(ProductVO vo) {
		return searchDao.searchAllDataTotalPage(vo);
	}
	public int searchAllDataTotalCount(ProductVO vo) {
		return searchDao.searchAllDataTotalCount(vo);
	}
	
	public List<ProductVO> searchCategoryDataList(Map map) {
		return searchDao.searchCategoryDataList(map);
	}
	public int searchCategoryDataTotalPage(ProductVO vo) {
		return searchDao.searchCategoryDataTotalPage(vo);
	}
	public int searchCategoryDataTotalCount(ProductVO vo) {
		return searchDao.searchCategoryDataTotalCount(vo);
	}
	
	public List<ProductVO> recommendList() {
		List<ProductVO> recommList=dao.recommendList();
		for(ProductVO vo:recommList) {
			String pname=vo.getPname();
			if(pname.length()>43) {
				pname=pname.substring(0,42)+"...";
				vo.setPname(pname);
			}
		}
		return recommList;
	}
	public List<CpuVO> cpuContentsList(int page) {
		final int BLOCK=10;
		int cpuTotalPage=dao.cpuTotalPage();
		int rowSize=18;
		int start=(page*rowSize)-(rowSize-1);
		int end=page*rowSize;
		int startPage=((page-1)/BLOCK)*BLOCK+1;
		int endPage=((page-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > cpuTotalPage) {
			endPage = cpuTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<CpuVO> cpuList=dao.cpuContentsList(map);
		for(CpuVO vo:cpuList) {
			String cpu_name=vo.getCpu_name();
			if(cpu_name.length()>43) {
				cpu_name=cpu_name.substring(0,42)+"...";
				vo.setCpu_name(cpu_name);
			}
		}
		return cpuList;
	}
	public int cpuStartPage(int page) {
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK)*BLOCK+1;
		return startPage;
	}
	public int cpuEndPage(int page) {
		final int BLOCK=10;
		int cpuTotalPage=dao.cpuTotalPage();
		int endPage=((page-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > cpuTotalPage) {
			endPage = cpuTotalPage;
		}
		return endPage;
	}
	public int cpuTotalPage() {
		return dao.cpuTotalPage();
	}

	public List<RamVO> ramContentsList(Map map) {
		List<RamVO> ramList=dao.ramContentsList(map);
		for(RamVO vo:ramList) {
			String ram_name=vo.getRam_name();
			if(ram_name.length()>43) {
				ram_name=ram_name.substring(0,42)+"...";
				vo.setRam_name(ram_name);
			}
		}
		return ramList;
	}
	public int ramTotalPage() {
		return dao.ramTotalPage();
	}

	public List<MainVO> mainContentsList(Map map) {
		List<MainVO> mainList=dao.mainContentsList(map);
		for(MainVO vo:mainList) {
			String main_name=vo.getMain_name();
			if(main_name.length()>43) {
				main_name=main_name.substring(0,42)+"...";
				vo.setMain_name(main_name);
			}
		}
		return mainList;
	}
	public int mainTotalPage() {
		return dao.mainTotalPage();
	}

	public List<VgaVO> vgaContentsList(Map map) {
		List<VgaVO> vgaList=dao.vgaContentsList(map);
		for(VgaVO vo:vgaList) {
			String vga_name=vo.getVga_name();
			if(vga_name.length()>43) {
				vga_name=vga_name.substring(0,42)+"...";
				vo.setVga_name(vga_name);
			}
		}
		return vgaList;
	}
	public int vgaTotalPage() {
		return dao.vgaTotalPage();
	}

	public List<SsdVO> ssdContentsList(Map map) {
		List<SsdVO> ssdList=dao.ssdContentsList(map);
		for(SsdVO vo:ssdList) {
			String ssd_name=vo.getSsd_name();
			if(ssd_name.length()>43) {
				ssd_name=ssd_name.substring(0,42)+"...";
				vo.setSsd_name(ssd_name);
			}
		}
		return ssdList;
	}
	public int ssdTotalPage() {
		return dao.ssdTotalPage();
	}

	public List<HddVO> hddContentsList(Map map) {
		List<HddVO> hddList=dao.hddContentsList(map);
		for(HddVO vo:hddList) {
			String hdd_name=vo.getHdd_name();
			if(hdd_name.length()>43) {
				hdd_name=hdd_name.substring(0,42)+"...";
				vo.setHdd_name(hdd_name);
			}
		}
		return hddList;
	}
	public int hddTotalPage() {
		return dao.hddTotalPage();
	}

	public List<PowerVO> powerContentsList(Map map) {
		List<PowerVO> powerList=dao.powerContentsList(map);
		for(PowerVO vo:powerList) {
			String power_name=vo.getPower_name();
			if(power_name.length()>43) {
				power_name=power_name.substring(0,42)+"...";
				vo.setPower_name(power_name);
			}
		}
		return powerList;
	}
	public int powerTotalPage() {
		return dao.powerTotalPage();
	}

}
