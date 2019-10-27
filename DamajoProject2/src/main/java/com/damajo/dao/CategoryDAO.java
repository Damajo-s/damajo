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
	
	public int cpuTotalCount() {
		return mapper.cpuTotalCount();
	}
	
	public int ramTotalCount() {
		return mapper.ramTotalCount();
	}
	
	public int mainTotalCount() {
		return mapper.mainTotalCount();
	}
	
	public int vgaTotalCount() {
		return mapper.vgaTotalCount();
	}
	
	public int ssdTotalCount() {
		return mapper.ssdTotalCount();
	}
	
	public int hddTotalCount() {
		return mapper.hddTotalCount();
	}
	
	public int powerTotalCount() {
		return mapper.powerTotalCount();
	}
}
