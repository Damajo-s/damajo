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
		int count = dao.mysignup(id, type);
		
		if (count == 1) {
			// 로그인
			result=1;
		} else if (count == 0) {
			int count2 = dao.idCheck(id);
			if (count2 == 1) {
				// 꺼져
				result=2;
			} else if (count2 == 0) {
				// 환영~~
				result=3;
			}
		}
		return result;
	}
}
