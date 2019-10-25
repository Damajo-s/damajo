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
import com.damajo.vo.CPUVO;
import com.damajo.vo.CategoryVO;
import com.damajo.vo.QABoardVO;
import com.damajo.vo.RAMVO;
import com.damajo.vo.SSDVO;
import com.damajo.vo.VideoBoardVO;

@Controller
public class MainController {
	@Autowired
	private VideoBoardDAO vdao;
	@Autowired
	private QABoardDAO qdao;
	@Autowired
	private MainDAO cdao;
	@Autowired
	private CategoryService cateService;
	
	@RequestMapping("main/main.do")
	public String main_main(Model model) {

		Map map = new HashMap();
		List<CPUVO> crlist = cdao.CPURecomList(map);
		List<CPUVO> cnlist = cdao.CPUNewList(map);
		List<SSDVO> snlist = cdao.SSDNewList(map);
		List<SSDVO> srlist = cdao.SSDRecomList(map);
		List<RAMVO> rnlist = cdao.RAMNewList(map);
		List<RAMVO> rrlist = cdao.RAMRecomList(map);

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
	// QA새글
	@RequestMapping("shop/qainsert_ok.do")
	public String shop_insert(int product,String subject,String content, Model model, HttpSession session) {
		// 아이디 비밀번호 session에서 처리?
		QABoardVO vo = new QABoardVO();
		String id = "sj6239@naver.com"; //(String) session.getAttribute("id");
		vo.setId(id);
		vo.setPno(product);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setAdminres("답변 대기중입니다.");
		System.out.println(product);
		System.out.println(subject);
		System.out.println(content);
		qdao.qaboardInsert(vo);
		return "shop/detail";
	}

	// Q&A 리스트
	@RequestMapping("shop/detail.do")
	public String shop_detail(String page, int product, Model model) {
		if (page == null) { 
			page = "1";
		}
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal();
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,product);
		model.addAttribute("curpage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", product);
		return "shop/detail";
	}

	// 수정하기

	// 삭제하기

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
