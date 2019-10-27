package com.damajo.mvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.dao.QABoardDAO;
import com.damajo.service.MemberService;
import com.damajo.vo.MemberVO;
import com.damajo.vo.QABoardVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private QABoardDAO qnadao;

	@RequestMapping("member/login.do")
	public String login(Model model) {
		return "member/login";
	}

	@RequestMapping("member/naverlogincallback")
	public String login() {
		return "member/naverlogincallback";
	}

	@RequestMapping("member/damajologin")
	public String damajoLogin(MemberVO vo, HttpSession session) {
		return "member/damajoLogin";
	}

	@RequestMapping("member/damajosignup")
	public String damajoSignup(MemberVO vo) {
		return "member/damajoSignup";
	}

	@RequestMapping("member/logout.do")
	public String logout(Model model, HttpSession session) {
		ms.logout(session);
		return "redirect:../main/main.do";
	}

	@RequestMapping("member/findpassword.do")
	public String findpassword() {
		return "member/findpassword";
	}

	@RequestMapping("member/checkhint.do")
	public String checkhint(Model model, String id) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo = ms.memberDetailInfo(vo);
		String hint = vo.getHint();
		model.addAttribute("hint", hint);
		model.addAttribute("id", id);
		return "member/checkhint";
	}

	@RequestMapping("member/changepassword.do")
	public String changepassword(Model model, String id) {
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo = ms.memberDetailInfo(vo);
		model.addAttribute("id", id);
		return "member/changepassword";
	}

	@RequestMapping("member/adminpage.do")
	public String adminpage() {
		return "member/adminpage";
	}

	@RequestMapping("member/mypage.do")
	public String mypage(Model model, HttpSession session) {
		String page = "1";
		String id = (String) session.getAttribute("id");
		// 페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qnadao.myqaboardTotal(id);
		int BLOCK = 5;
		int startPage = ((curPage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curPage - 1) / BLOCK * BLOCK) + BLOCK;
		int allPage = totalPage;
		if (endPage > allPage) {
			endPage = allPage;
		}
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("id",id);
		return "member/mypage";
	}

	@RequestMapping("member/mydetail_page.do")
	public String myDetailPage(Model model, HttpSession session, String page) {
		String id = (String) session.getAttribute("id");
		// 페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qnadao.myqaboardTotal(id);
		int BLOCK = 5;
		int startPage = ((curPage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curPage - 1) / BLOCK * BLOCK) + BLOCK;
		int allPage = totalPage;
		if (endPage > allPage) {
			endPage = allPage;
		}
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		List<QABoardVO> list = qnadao.myqaboardList(curPage, id);
		model.addAttribute("list", list);
		return "mydetail_page";
	}

	@RequestMapping("member/deleteaccount")
	public String deleteAccount() {
		
		return "member/deleteaccount";
	}

}
