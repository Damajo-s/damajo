package com.damajo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("member/login.do")
	public String login(Model model) {
		return "member/login";
	}

	@RequestMapping("member/naverlogincallback")
	public String login() {
		return "member/naverlogincallback";
	}
}
