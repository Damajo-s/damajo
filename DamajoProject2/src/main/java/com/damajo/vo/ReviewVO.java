package com.damajo.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewVO {
/*	  r_no NUMBER NOT NULL, --pk : 게시물번호
	  r_pno NUMBER NOT NULL, -- fk : product 번호
	  id VARCHAR2(34) CONSTRAINT review_rid_nn NOT NULL,
	  r_subject VARCHAR2(2000) CONSTRAINT review_rsub_nn NOT NULL,
	  r_content CLOB CONSTRAINT review_rcont_nn NOT NULL,
	  r_regdate DATE DEFAULT SYSDATE,
	  category NUMBER */
	private int r_no;
	private int r_pno;
	private String id;
	private String r_subject;
	private String r_content;
	private Date r_regdate;
	private String today;
	private int category;
}
