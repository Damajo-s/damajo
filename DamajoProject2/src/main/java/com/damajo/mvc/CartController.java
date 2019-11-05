package com.damajo.mvc;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.vo.CartVO;
import com.damajo.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cs;

	
	@RequestMapping("cart/cartAdd.do")
	public String cartAdd(String id, String pno, String pcate, String img, Model model, HttpSession session) {
		CartVO vo = new CartVO();
		id = (String)session.getAttribute("id");
		//pno = Integer.parseInt(s);
		vo.setId(id);
		vo.setPno(Integer.parseInt(pno));
		vo.setCartNo(Integer.parseInt(pno));
		vo.setPcate(Integer.parseInt(pcate));
		
		cs.cartInsert(vo);
		
		return "shop/shop_list";
	}

	
	@RequestMapping("cart/cart_list.do")
	public String cart_list(Model model, HttpSession session) {

		return "cart/cart_list";
	}
}
