package com.damajo.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * RAM_NO	NUMBER
RAM_NAME	VARCHAR2(300 BYTE)
POSTER		VARCHAR2(1000 BYTE)
PRICE		VARCHAR2(200 BYTE)
COMPANY		VARCHAR2(30 BYTE)
REGDATE		VARCHAR2(100 BYTE)
KIND		VARCHAR2(20 BYTE)
MEMORY_CAPACITY	VARCHAR2(20 BYTE)
CLOCK		VARCHAR2(30 BYTE)
 */
@Setter
@Getter
public class RamVO {
	private int ram_no;
	private String ram_name;
	private String poster;
	private String price;
	private String company;
	private String regdate;
	private String kind;
	private String memory_capacity;
	private String clock;
}
