package com.damajo.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.dao.QABoardDAO;
import com.damajo.vo.QABoardVO;

@Controller
public class QnABoardController {
	@Autowired
	private QABoardDAO qdao;
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
	public String shop_detail(String page, int product,Model model){
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
		System.out.println("처음:"+curPage);
		System.out.println("처음:"+product);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", product);
		return "shop/detail";
	}
	// Q&A 리스트
		@RequestMapping("shop/detail_page.do")
		public String shop_detail_page(String page, int product,Model model){
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
			System.out.println("두번:"+curPage);
			System.out.println("두번:"+product);
			model.addAttribute("curPage", curPage);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("BLOCK", BLOCK);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("allPage", allPage);
			model.addAttribute("list", list);
			model.addAttribute("product", product);
			return "detail_page";
		}
}
