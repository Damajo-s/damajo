package com.damajo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damajo.service.MemberService;

@RestController
public class MemberRestController {
	@Autowired
	private MemberService ms;
	
	@RequestMapping("member/login_ok.do")
	public String login_ok(String id, int type) {
		int result=ms.loginCheck(id, type);
		if(result==1) { // 로그인
			
		}else if(result==2) { // 이미 존재 => 연동해제
			
		}if(result==3) { // 회원가입
			
		}
		return String.valueOf(result);
	}
}
