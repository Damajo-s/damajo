package com.damajo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.*;
import com.damajo.vo.CartVO;


public interface CartMapper {
	// 카트 추가
	@Insert("INSERT INTO cart VALUES((SELECT NVL(MAX(cartno)+1,1) FROM cart), #{id}, #{pno}, #{pname}, #{pPrice}")
	public void cartInsert(CartVO vo);
	
	// 카트 물품 개수
	@Select("SELECT COUNT(*) FROM cart WHERE id = #{id}")
	public int cartCount(String id);
	
	// 카트 삭제
	@Delete("DELETE FROM cart WHERE cartno = #{cartno}")
	public void cartDelete(int cartno);
	
	// 카트 리스트 출력
	@Select("SELECT * FROM cart WHERE id = #{id}")
	public List<CartVO> cartList(String id);
}
