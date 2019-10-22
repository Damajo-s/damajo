package com.damajo.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.dao.MainDAO;
import com.damajo.dao.VideoBoardDAO;
import com.damajo.vo.CPUVO;
import com.damajo.vo.SSDVO;
import com.damajo.vo.VideoBoardVO;
@Controller
public class MainController {
	@Autowired
	private VideoBoardDAO vdao;
	@Autowired
	private MainDAO cdao;
	@RequestMapping("main/main.do")
	public String main_main(Model model){

		Map map = new HashMap();
		List<CPUVO> crlist = cdao.CPURecomList(map);
		List<CPUVO> cnlist = cdao.CPUNewList(map);
		List<SSDVO> snlist = cdao.SSDNewList(map);
		List<SSDVO> srlist = cdao.SSDRecomList(map);
		model.addAttribute("crlist", crlist);
		model.addAttribute("cnlist", cnlist);
		model.addAttribute("snlist", snlist);
		model.addAttribute("srlist", srlist);
		
		return "main";
	}
	//상품-상세정보
	@RequestMapping("shop/detail.do")
	public String shop_detail(){
		return "shop/detail";
	}
	//상품 카테고리 
	@RequestMapping("shop/shop_list.do")
	public String shop_list(){
		return "shop/shop_list";
	}
	//팁게시판
	@RequestMapping("tipboard/list.do")
	public String tipboard_list(Model model){
		List<VideoBoardVO> list = vdao.videoboard_list();
		model.addAttribute("list", list);
		return "tipboard/list";
	}
	//상세보기
	@RequestMapping("tipboard/tip_detail.do")
	public String tipboard_detail(int no,Model model){
		VideoBoardVO vo=vdao.videoboard_detail(no);
		model.addAttribute("vo", vo);
		return "tipboard/tip_detail";
	}
	
	
	
	
	
}
