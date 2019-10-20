package com.damajo.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damajo.service.MemberService;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService ms;

	@RequestMapping("member/login_ok.do")
	public String login_ok(String id, int type, HttpSession session) {
		System.out.println(id);
		int result = ms.loginCheck(id, type);
		if (result == 1) { // 로그인
			session.setAttribute("id", id);
			session.setAttribute("type", type);
		} else if (result == 2) { // 이미 존재 => 연동해제

		}
		if (result == 3) { // 회원가입
			// ms.apiSignup(id, type);
			System.out.println("가입");
		}
		return String.valueOf(result);
	}

}
