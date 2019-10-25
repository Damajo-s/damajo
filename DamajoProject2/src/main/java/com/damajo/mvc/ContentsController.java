package com.damajo.mvc;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.damajo.service.ContentsService;
import com.damajo.vo.CPUVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;

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
	public String ramList(Model model) {
		List<RAMVO> ramList=service.ramContentsList();
		model.addAttribute("ramList", ramList);
		return "ram_list";
	}
	
	@RequestMapping("shop/main_list.do")
	public String mainList(Model model) {
		List<MAINVO> mainList=service.mainContentsList();
		model.addAttribute("mainList", mainList);
		return "main_list";
	}
}
