package com.damajo.mvc;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.vo.CartVO;
import com.damajo.dao.CartDAO;
import com.damajo.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cs;
	
	@RequestMapping("cartAdd_ok.do")
	public String cartAdd(String id) {
		
		return "";
	}
	
}
