package com.damajo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damajo.dao.CategoryDAO;
import com.damajo.vo.CategoryVO;

@Service
public class ShopService {
	@Autowired
	private CategoryDAO dao;
	
	public List<CategoryVO> category() {
		List<CategoryVO> list=dao.category();
		
		return list;
	}
}
