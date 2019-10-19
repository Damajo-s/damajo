package com.damajo.service;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.MemberDAO;
import com.damajo.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;

	public int loginCheck(String id, int type) {
		int result = 0;
		int fChk = dao.damajoSignupCheck(id, type);
		if (fChk == 1) {
			// login
			result=1;
		} else if (fChk == 0) {
			int sChk = dao.idCheck(id);
			if (sChk == 1) {
				// Existing ID
				result=2;
			} else if (sChk == 0) {
				// Sing up
				result=3;
			}
		}
		return result;
	}
	
	public void apiSignup(String id, int type){
		dao.apiSignup(id, type);
	}
	
	public void damajoSignup(MemberVO vo) {
		dao.damajoSignup(vo);
	}
	
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	
}
