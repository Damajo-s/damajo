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
	final static int LOGIN =1;
	final static int EXIST_ID =2;
	final static int SIGN_UP = 3;
	final static int PASSWORD_INCORRECT = 4;
	
	public int loginCheck(MemberVO vo) {
		int result = 0;
		if (vo.getType() == 1) {
			result = (dao.passwordCheck(vo) == 1) ? LOGIN : PASSWORD_INCORRECT;
		} else {
			int signupCheckResult = dao.damajoSignupCheck(vo);
			if (signupCheckResult == 1) {
				// login
				result = LOGIN;
			} else if (signupCheckResult == 0) {
				int idExistCheckResult = dao.idCheck(vo);
				if (idExistCheckResult == 1) {
					// Existing ID
					result = EXIST_ID;
				} else if (idExistCheckResult == 0) {
					// Sing up
					result = SIGN_UP;
				}
			}
		}
		return result;
	}

	public void apiSignup(MemberVO vo) {
		dao.apiSignup(vo);
	}

	public void damajoSignup(MemberVO vo) {
		dao.damajoSignup(vo);
	}

	public void logout(HttpSession session) {
		session.invalidate();
	}

}
