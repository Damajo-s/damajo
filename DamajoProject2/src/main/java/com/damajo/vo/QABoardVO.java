package com.damajo.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
/*
 *   type NUMBER,
  no NUMBER,
  id VARCHAR2(34) CONSTRAINT qb_id_nn NOT NULL,
  subject VARCHAR2(2000) CONSTRAINT qb_sub_nn NOT NULL,
  content CLOB CONSTRAINT qb_cont_nn NOT NULL,
  pwd VARCHAR2(10) CONSTRAINT qb_pwd_nn NOT NULL,
  regdate DATE DEFAULT SYSDATE,
  hit NUMBER DEFAULT 0,
  adminres CLOB*/
@Getter
@Setter
public class QABoardVO {
	private int no;
	private int pno;
	private String id;
	private String subject;
	private String content;
	private Date regdate;
	private String today;
	private String adminres;
}
