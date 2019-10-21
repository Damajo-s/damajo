package com.damajo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.damajo.vo.CategoryVO;
import com.damajo.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService service;
	
	@RequestMapping("shop/shop_list.do")
	public String category(Model model) {
		List<CategoryVO> cateList=service.category();
		model.addAttribute("cateList",cateList);
		return "shop/shop_list";
	}
}
