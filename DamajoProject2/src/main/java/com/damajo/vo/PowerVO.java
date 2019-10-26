package com.damajo.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PowerVO {
	private int power_no;
	private String power_name;
	private String poster;
	private String price;
	private String company;
	private String regdate;
	// 기본 사양
	private String product_type;
	private String rated_power;
	private String main_connector;
	private String fan_size;
	private String fan_cnt;
	private String bearing;
	private String pfc_circuit;
	private String depth;
	// 전압 규격
	private String voltage_specification;
	// 전류 용량
	private String way_to_output_12v;
	private String output12v;
	private String output5v;
	private String output3_3v;
	// 커넥터
	private String connector_4pinIDE;
	private String connector_sata;
	private String connector_6pinPCIe;
	private String connector_8pinPCIe;
	private String connector_4by4pinSub;
	private String connector_8pinSub;
	private String connector_4pinSub;
	private String connector_fdd;
	private String connector_led;
	// 부가 기능
	private String cable_attached;
	private String stanby_power;
	private String flat_cable;
	private String warranty;
}
