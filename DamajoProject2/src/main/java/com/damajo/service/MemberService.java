package com.damajo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.MemberDAO;
import com.damajo.vo.MemberVO;
import com.damajo.vo.QABoardVO;

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

	public int findPassword(MemberVO vo) {
		return dao.damajoSignupCheck(vo);
	}

	public MemberVO memberDetailInfo(MemberVO vo) {
		return dao.memberDetailInfo(vo);
	}

	public String memberHintCheck(MemberVO vo) {
		String dbHintAnswer = dao.memberDetailInfo(vo).getHint_answer();
		String hintAnswer = vo.getHint_answer();
		System.out.println(dbHintAnswer);
		System.out.println(hintAnswer);
		if (dbHintAnswer.equals(hintAnswer)) {
			return "true";
		} else
			return "false";
	}

	public void changePassword(MemberVO vo) {
		dao.changePassword(vo);
	}

	public String deleteAccount(MemberVO vo,HttpSession session) {
		MemberVO dbvo = dao.memberDetailInfo(vo);
		if (vo.getPwd().equals(dbvo.getPwd())) {
			session.invalidate();
			dao.leaveAccount(vo);
			return "true";
		} else {
			return "false";
		}
	}
	public void banAccount(MemberVO vo){
		dao.leaveAccount(vo);
	}
	public List<MemberVO> viewUserList(int page){
		Map map = new HashMap<>();
		int rowSize = 5;
		int start = (page * rowSize) - (rowSize - 1); 
		int end = (page * rowSize); 
		map.put("start", start);
		map.put("end", end);
		return dao.userList(map);
	}
	public int qnaTotalPage(QABoardVO vo){
		return dao.qnaTotalPage(vo);
	}
	public int adminMemberPageCount(){
		return dao.adminMemberPageCount();
	}
	public void adminresUpdate(QABoardVO vo){
		dao.adminresUpdate(vo);
	}
}
