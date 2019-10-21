package com.damajo.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damajo.service.MemberService;
import com.damajo.vo.MemberVO;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService ms;

	@RequestMapping("member/api_login_ok.do")
	public String login_ok(MemberVO vo, HttpSession session) {
		int result = ms.loginCheck(vo);
		System.out.println(vo.getId());
		System.out.println(vo.getPwd());
		if (result == 1) { // 로그인
			session.setAttribute("id", vo.getId());
			session.setAttribute("type", vo.getType());
		} else if (result == 2) { // 이미 존재 => 연동해제
			System.out.println("이미 존재하는 메일일경우");
		}
		if (result == 3) { // 회원가입
			ms.signup(vo);
			session.setAttribute("id", vo.getId());
			session.setAttribute("type", vo.getType());
			System.out.println("가입");
		} 
		return String.valueOf(result);
	}

}
