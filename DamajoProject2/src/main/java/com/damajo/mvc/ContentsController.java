package com.damajo.mvc;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.damajo.service.ContentsService;
import com.damajo.vo.CPUVO;
import com.damajo.vo.HDDVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;
import com.damajo.vo.SSDVO;
import com.damajo.vo.VGAVO;

@Controller
public class ContentsController {
	@Autowired
	private ContentsService service;
	
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
		
		List<CPUVO> cpuList=service.cpuContentsList(map);
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
		
		List<RAMVO> ramList=service.ramContentsList(map);
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
		
		List<MAINVO> mainList=service.mainContentsList(map);
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
		
		List<VGAVO> vgaList=service.vgaContentsList(map);
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
		
		List<SSDVO> ssdList=service.ssdContentsList(map);
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
		
		List<HDDVO> hddList=service.hddContentsList(map);
		model.addAttribute("hddList", hddList);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hddTotalPage", hddTotalPage);
		model.addAttribute("BLOCK", BLOCK);
		return "hdd_list";
	}
}
