package com.damajo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.service.MemberService;

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
	
}
