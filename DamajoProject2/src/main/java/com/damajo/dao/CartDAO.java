package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.CartMapper;
import com.damajo.vo.CartVO;

@Repository
public class CartDAO {
	@Autowired
	private CartMapper mapper;
	
	public int cartCount(String id) {
		return mapper.cartCount(id);
	}
	
	public void cartInsert(CartVO vo) {
		mapper.cartInsert(vo);
	}
	
	public void cartDelete(int cartno) {
		mapper.cartDelete(cartno);
	}
	
	public List<CartVO> cartList(String id) {
		return mapper.cartList(id);
	}
}
