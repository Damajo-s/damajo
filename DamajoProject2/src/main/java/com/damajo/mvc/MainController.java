package com.damajo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(){
		return "main";
	}
	//상품-상세정보
	@RequestMapping("shop/detail.do")
	public String shop_detail(){
		return "shop/detail";
	}
	//상품 리스트
	@RequestMapping("shop/shop_list.do")
	public String shop_list(){
		return "shop/shop_list";
	}
}
