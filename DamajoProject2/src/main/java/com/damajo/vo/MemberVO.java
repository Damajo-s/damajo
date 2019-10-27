package com.damajo.vo;

import lombok.Data;

@Data
public class MemberVO {
	private int no;
	private String id;
	private String pwd;
	private String hint;
	private String hint_answer;
	private int type;
}
	