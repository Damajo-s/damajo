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
	public String api_login_ok(MemberVO vo, HttpSession session) {
		int result = ms.apiLogin(vo);
		System.out.println(vo.getId());
		if (result == 1) { // 로그인
			session.setAttribute("id", vo.getId());
			session.setAttribute("type", vo.getType());
		} else if (result == 2) { // 이미 존재 => 연동해제
		}
		if (result == 3) { // 회원가입
			session.setAttribute("id", vo.getId());
			session.setAttribute("type", vo.getType());
			//System.out.println("가입");
			ms.signup(vo);
		}
		return String.valueOf(result);
	}

	@RequestMapping("member/damajo_login_ok.do")
	public String damajo_login_ok(MemberVO vo, HttpSession session) {
		int result = ms.damajo_login(vo);
		if (result == 1) { // 로그인
			session.setAttribute("id", vo.getId());
			session.setAttribute("type", vo.getType());
		}
		return String.valueOf(result);
	}

	@RequestMapping("member/damajo_signup_ok.do")
	public String damajo_signup(MemberVO vo, HttpSession session) {
		int result = 0;
		if (ms.signup(vo)) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("type", vo.getType());
			result = 1;
		}
		return String.valueOf(result);
	}

	@RequestMapping("member/findpassword_ok.do")
	public String find_password_ok(MemberVO vo) {
		return String.valueOf(ms.findPassword(vo));
	}

	@RequestMapping("member/checkhint_ok.do")
	public String checkhint_ok(MemberVO vo) {
		return ms.memberHintCheck(vo);
	}

	@RequestMapping("member/changepassword_ok.do")
	public String changepassword(MemberVO vo) {
		ms.changePassword(vo);
		return "success";
	}

	@RequestMapping("member/deleteaccount_ok.do")
	public String deleteaccount_ok(MemberVO vo) {
		return ms.deleteAccount(vo);
	}
}
