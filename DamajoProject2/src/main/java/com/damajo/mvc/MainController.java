package com.damajo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(){
		return "main";
	}
	//��ǰ-������
	@RequestMapping("shop/detail.do")
	public String shop_detail(){
		return "shop/detail";
	}
	//��ǰ ����Ʈ
	@RequestMapping("shop/shop_list.do")
	public String shop_list(){
		return "shop/shop_list";
	}
}
