package com.damajo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.MemberDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;

	public int loginCheck(String id, int type) {
		int result = 0;
		int fChk = dao.damajoSignup(id, type);
		
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
}
