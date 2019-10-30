package com.damajo.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.service.CompareSevice;
import com.damajo.service.ContentsService;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.ProductVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Controller
public class ContentsController {
	@Autowired
	private ContentsService service;
	@Autowired
	private CompareSevice service2;
	
	@RequestMapping("shop/find_list.do")
	public String searchDataList(String page, String category, String searchThis, Model model) {
		ProductVO vo=new ProductVO();
		vo.setSearchThis(searchThis); // 검색어 대입
		if(page==null) {
			page="1";
		}
		
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int searchTotalCount=0;
		int rowSize=20;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		
		// 페이지 총 개수
		if(category.equals("0")) { // 전체 검색
			int searchTotalPage=service.searchAllDataTotalPage(vo);
			searchTotalCount=service.searchAllDataTotalCount(vo);
			
			model.addAttribute("searchTotalPage",searchTotalPage);
			model.addAttribute("searchTotalCount",searchTotalCount);
			if (endPage > searchTotalPage) {
				endPage = searchTotalPage;
			}
		} else { // 카테고리 검색
			vo.setCategory(Integer.parseInt(category)); // 카테고리 값 넣기
			int searchTotalPage=service.searchCategoryDataTotalPage(vo);
			searchTotalCount=service.searchCategoryDataTotalCount(vo);
			model.addAttribute("searchTotalPage",searchTotalPage);
			model.addAttribute("searchTotalCount",searchTotalCount);
			if (endPage > searchTotalPage) {
				endPage = searchTotalPage;
			}
		}
		Map map=new HashMap();
		map.put("searchThis", searchThis);
		map.put("start", start);
		map.put("end", end);
		if(category.equals("0")) { // 전체 검색
			map.remove("category");
			List<ProductVO> searchList=service.searchAllDataList(map);
			model.addAttribute("searchList", searchList);
		} else { // 카테고리 검색
			map.put("category", category);
			List<ProductVO> searchList=service.searchCategoryDataList(map);
			model.addAttribute("searchList", searchList);
		}
		System.out.println(map.get("category"));
		System.out.println(map.get("searchThis"));
		System.out.println(map.get("start"));
		System.out.println(map.get("end"));
		
		model.addAttribute("searchThis", searchThis);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCK", BLOCK);
		return "shop/find_list";
	}
	@RequestMapping("shop/find_list_page.do")
	public String searchDataPage(String page, String category, String searchThis, Model model) {
		ProductVO vo=new ProductVO();
		vo.setSearchThis(searchThis); // 검색어 대입
		if(page==null) {
			page="1";
		}
		
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int searchTotalCount=0;
		int rowSize=20;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		
		// 페이지 총 개수
		if(category.equals("0")) { // 전체 검색
			int searchTotalPage=service.searchAllDataTotalPage(vo);
			searchTotalCount=service.searchAllDataTotalCount(vo);
			
			model.addAttribute("searchTotalPage",searchTotalPage);
			model.addAttribute("searchTotalCount",searchTotalCount);
			if (endPage > searchTotalPage) {
				endPage = searchTotalPage;
			}
		} else { // 카테고리 검색
			vo.setCategory(Integer.parseInt(category)); // 카테고리 값 넣기
			int searchTotalPage=service.searchCategoryDataTotalPage(vo);
			searchTotalCount=service.searchCategoryDataTotalCount(vo);
			model.addAttribute("searchTotalPage",searchTotalPage);
			model.addAttribute("searchTotalCount",searchTotalCount);
			if (endPage > searchTotalPage) {
				endPage = searchTotalPage;
			}
		}
		Map map=new HashMap();
		map.put("searchThis", searchThis);
		map.put("start", start);
		map.put("end", end);
		if(category.equals("0")) { // 전체 검색
			map.remove("category");
			List<ProductVO> searchList=service.searchAllDataList(map);
			model.addAttribute("searchList", searchList);
		} else { // 카테고리 검색
			map.put("category", category);
			List<ProductVO> searchList=service.searchCategoryDataList(map);
			model.addAttribute("searchList", searchList);
		}
		System.out.println(map.get("category"));
		System.out.println(map.get("searchThis"));
		System.out.println(map.get("start"));
		System.out.println(map.get("end"));
		
		model.addAttribute("searchThis", searchThis);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCK", BLOCK);
		return "find_list";
	}
	
	@RequestMapping("shop/cpu_list.do")
	public String cpuList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int cpuTotalPage=service.cpuTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > cpuTotalPage) {
			endPage = cpuTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<CpuVO> cpuList=service.cpuContentsList(map);
		model.addAttribute("cpuList", cpuList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cpuTotalPage", cpuTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "cpu_list";
	}

	@RequestMapping("shop/ram_list.do")
	public String ramList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int ramTotalPage=service.ramTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > ramTotalPage) {
			endPage = ramTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<RamVO> ramList=service.ramContentsList(map);
		model.addAttribute("ramList", ramList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("ramTotalPage", ramTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "ram_list";
	}

	@RequestMapping("shop/main_list.do")
	public String mainList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int mainTotalPage=service.mainTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > mainTotalPage) {
			endPage = mainTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<MainVO> mainList=service.mainContentsList(map);
		model.addAttribute("mainList", mainList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("mainTotalPage", mainTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "main_list";
	}

	@RequestMapping("shop/vga_list.do")
	public String vgaList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int vgaTotalPage=service.vgaTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > vgaTotalPage) {
			endPage = vgaTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<VgaVO> vgaList=service.vgaContentsList(map);
		model.addAttribute("vgaList", vgaList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("vgaTotalPage", vgaTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "vga_list";
	}

	@RequestMapping("shop/ssd_list.do")
	public String ssdList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int ssdTotalPage=service.ssdTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > ssdTotalPage) {
			endPage = ssdTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<SsdVO> ssdList=service.ssdContentsList(map);
		model.addAttribute("ssdList", ssdList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("ssdTotalPage", ssdTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "ssd_list";
	}

	@RequestMapping("shop/hdd_list.do")
	public String hddList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int hddTotalPage=service.hddTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > hddTotalPage) {
			endPage = hddTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<HddVO> hddList=service.hddContentsList(map);
		model.addAttribute("hddList", hddList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hddTotalPage", hddTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "hdd_list";
	}

	@RequestMapping("shop/power_list.do")
	public String powerList(String page, Model model) {
		if(page==null) {
			page="1";
		}
		final int BLOCK=10;
		int curpage=Integer.parseInt(page);
		int powerTotalPage=service.powerTotalPage();
		int rowSize=18;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;
		int endPage=((curpage-1)/BLOCK)*BLOCK+BLOCK;
		if (endPage > powerTotalPage) {
			endPage = powerTotalPage;
		}
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);

		List<PowerVO> powerList=service.powerContentsList(map);
		model.addAttribute("powerList", powerList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("powerTotalPage", powerTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "power_list";
	}
}
