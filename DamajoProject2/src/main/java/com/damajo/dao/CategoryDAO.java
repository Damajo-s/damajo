package com.damajo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.CategoryMapper;
import com.damajo.vo.CategoryVO;

@Repository
public class CategoryDAO {
	@Autowired
	private CategoryMapper mapper;
	
	public List<CategoryVO> category() {
		return mapper.category();
	}
}
