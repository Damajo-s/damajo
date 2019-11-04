package com.damajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.CartDAO;
import com.damajo.mapper.CartMapper;
import com.damajo.vo.CartVO;

@Service
public class CartService {
	@Autowired
	private CartDAO dao;
	
	public void cartInsert(CartVO vo) {
		dao.cartInsert(vo);
	}

	public int cartCount(String id) {
		return dao.cartCount(id);
	}

	public void cartDelete(int cartno) {
		dao.cartDelete(cartno);
	}

	public List<CartVO> cartList(String id) {
		return dao.cartList(id);
	}

}
