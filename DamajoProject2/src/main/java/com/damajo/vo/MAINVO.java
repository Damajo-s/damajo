package com.damajo.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MAINVO {
	private int main_no;
	private String main_name;
	private String poster;
	private String price;
	private String company;
	private String regdate;
	// 기본 사양
	private String product_type; // 2 제품분류
	private String cpu_socket; // 3
	private String main_chipset; // 4/X 칩셋 라인업 (인텔만)
	private String detail_chipset; // 5/4 세부 칩셋
	private String cpu_cnt; // 6/X CPU 장착수 (인텔만)
	private String formFactor; // 7/5
	private String power_supply; // 8/6
	// 메모리 사양
	private String memory_kind; // 50/8
	private String memory_speed; // 11/9
	private String memory_slot; // 12/50
	private String memory_channel; // 13/11
	private String memory_capacity; // 14/12
	// 그래픽
	private String multi_vga; // 16/16
	private String vga_connection; // 17/17
	// 그래픽 출력
	private String d_sub; // 20/X
	private String dvi; // 21/X
	private String hdmi; // 22/X
	private String dp; // 23/X
	// 확장 슬롯
	private String pcie_x16; // 24/18
	private String pcie_x8; // 25/19
	private String pcie_x4; // 26/20
	private String pcie_x1; // 27/21
	// 저장 장치
	private String m2; // 30/24
	private String sata3; // 32/26
	// 오디오
	private String built_in_sound; // 36/30
	private String analog; // 37/31
	private String spdif; // 38/32
	// 후면 단자
	private String usb_31_gen2; // 40/34
	private String usb_31_gen1; // 41/35
	// USB 타입
	private String type_c_gen2; // 48/42
	private String type_a_gen2; // 49/43
	private String type_c_gen1; // 50/44
	// 네트워크
	private String network_chipset; // 52/46
	private String rj_45port; // 53/47
	// LAN 구성
	private String gigabit_lan; // 54/48
	private String wireless_lan; // 58/52
}
