package com.damajo.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.service.MemberService;
import com.damajo.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;

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
	public void logout(Model model, HttpSession session) {
		ms.logout(session);
	}

}
