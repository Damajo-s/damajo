package com.damajo.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * SSD_NO		NUMBER
SSD_NAME		VARCHAR2(300 BYTE)
POSTER			VARCHAR2(1000 BYTE)
PRICE			VARCHAR2(200 BYTE)
COMPANY			VARCHAR2(30 BYTE)
REGDATE			VARCHAR2(500 BYTE)
PRODUCT_TYPE	VARCHAR2(500 BYTE)
DISK_TYPE		VARCHAR2(500 BYTE)
SSD_INTERFACE	VARCHAR2(500 BYTE)
PROTOCOL		VARCHAR2(500 BYTE)
DISK_CAPACITY	VARCHAR2(500 BYTE)
MEMORY_TYPE		VARCHAR2(30 BYTE)
NAND_STRUCTURE	VARCHAR2(30 BYTE)
CONTROLLER		VARCHAR2(30 BYTE)
RAM_MOUNT		VARCHAR2(30 BYTE)
RAM_TYPE		VARCHAR2(30 BYTE)
TBW				VARCHAR2(30 BYTE)
WARRANTY_TIME	VARCHAR2(50 BYTE)
 */
@Setter
@Getter
public class SSDVO {
	private int ssd_no;
	private String ssd_name;
	private String poster;
	private String price;
	private String company;
	private String regdate;
	private String product_type;
	private String disk_type;
	private String ssd_interface;
	private String protocol;
	private String disk_capcity;
	private String memory_type;
	private String nand_structure;
	private String controller;
	private String ram_mount;
	private String ram_type;
	private String tbw;
	private String warranty_time;
}
