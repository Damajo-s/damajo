package com.damajo.mvc;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.dao.MainDAO;
import com.damajo.dao.QABoardDAO;
import com.damajo.dao.VideoBoardDAO;
import com.damajo.service.CategoryService;
import com.damajo.vo.CpuVO;
import com.damajo.vo.CategoryVO;
import com.damajo.vo.QABoardVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VideoBoardVO;

@Controller
public class MainController {
	@Autowired
	private VideoBoardDAO vdao;

	@Autowired
	private MainDAO cdao;
	@Autowired
	private CategoryService cateService;
	
	@RequestMapping("main/main.do")
	public String main_main(Model model) {

		Map map = new HashMap();
		List<CpuVO> crlist = cdao.CPURecomList(map);
		List<CpuVO> cnlist = cdao.CPUNewList(map);
		List<SsdVO> snlist = cdao.SSDNewList(map);
		List<SsdVO> srlist = cdao.SSDRecomList(map);
		List<RamVO> rnlist = cdao.RAMNewList(map);
		List<RamVO> rrlist = cdao.RAMRecomList(map);

		model.addAttribute("crlist", crlist);
		model.addAttribute("cnlist", cnlist);
		model.addAttribute("snlist", snlist);
		model.addAttribute("srlist", srlist);
		model.addAttribute("rnlist", rnlist);
		model.addAttribute("rrlist", rrlist);

		return "main";
	}
	// 상품 Q&A 작성하기 창 띄우기
	@RequestMapping("shop/qainsert.do")
	public String shop_qainsert(int product,Model model){
		model.addAttribute("product", product);
		return "qainsert";
	}

	// 상품 카테고리
	@RequestMapping("shop/shop_list.do")
	public String shop_list(Model model) {
		List<CategoryVO> cateList=cateService.category();
		model.addAttribute("cateList",cateList);
		return "shop/shop_list";
	}

	// 팁게시판
	@RequestMapping("tipboard/list.do")
	public String tipboard_list(Model model) {
		List<VideoBoardVO> list = vdao.videoboard_list();
		model.addAttribute("list", list);
		return "tipboard/list";
	}

	// 상세보기
	@RequestMapping("tipboard/tip_detail.do")
	public String tipboard_detail(int no, Model model) {
		VideoBoardVO vo = vdao.videoboard_detail(no);
		model.addAttribute("vo", vo);
		return "tipboard/tip_detail";
	}
	
	// 장바구니 (이동)
	@RequestMapping("cart/cart_list.do")
	public String cart_list(Model model) {
		
		return "cart/cart_list";
	}

}
