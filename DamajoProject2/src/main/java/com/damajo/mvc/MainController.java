package com.damajo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(){
		return "main";
	}
	@RequestMapping("detail/detail.do")
	public String main_detail(){
		return "detail/detail";
	}
}
