package com.damajo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.MemberDAO;
import com.damajo.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	final static int LOGIN = 1;
	final static int EXIST_ID = 2;
	final static int SIGN_UP = 3;
	final static int PASSWORD_INCORRECT = 4;
	final static int NO_ID = 5;

	public int apiLogin(MemberVO vo) {
		int result = 0;
		result = dao.damajoSignupCheck(vo) == 1 ? LOGIN : (dao.damajoIdCheck(vo) == 1 ? EXIST_ID : SIGN_UP);
		System.out.println(result);
		return result;
	}

	public int damajo_login(MemberVO vo) {
		int result = 0;
		result = dao.damajoSignupCheck(vo) == 1 ? (dao.passwordCheck(vo) == 1 ? LOGIN : PASSWORD_INCORRECT) : NO_ID;
		return result;
	}

	public boolean signup(MemberVO vo) {
		boolean isSuccess = false;
		if (vo.getType() == 1) {
			if (dao.idCheck(vo) != 1) {
				dao.damajoSignup(vo);
				isSuccess = true;
			}
		} else {
			dao.apiSignup(vo);
			isSuccess = true;
		}
		return isSuccess;
	}

	public void logout(HttpSession session) {
		session.invalidate();
	}

}
