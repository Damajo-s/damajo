package com.damajo.vo;

import lombok.Getter;
import lombok.Setter;
/*
 * CPU_NO	NUMBER
CPU_NAME	VARCHAR2(300 BYTE)
POSTER	VARCHAR2(1000 BYTE)
PRICE	VARCHAR2(200 BYTE)
COMPANY	VARCHAR2(30 BYTE)
REGDATE	VARCHAR2(100 BYTE)
KIND	VARCHAR2(100 BYTE)
SOCKET	VARCHAR2(50 BYTE)
CORE	VARCHAR2(30 BYTE)
THREAD	VARCHAR2(30 BYTE)
DEFCLOCK	VARCHAR2(20 BYTE)
 */
@Setter
@Getter
public class CpuVO {
	private int cpu_no;
	private String cpu_name;
	private String poster;
	private String price;
	private String company;
	private String regdate;
	private String kind;
	private String socket;
	private String core;
	private String thread;
	private String defclock;
}
