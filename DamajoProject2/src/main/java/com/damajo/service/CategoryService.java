package com.damajo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damajo.dao.CategoryDAO;
import com.damajo.vo.CategoryVO;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO dao;
	
	public List<CategoryVO> category() {
		List<CategoryVO> list=dao.category();
		return list;
	}
	
	public int[] severalTotalCount() {
		int[] severalTotalCount={cpuTotalCount(), ramTotalCount(), mainTotalCount(), vgaTotalCount(),
								ssdTotalCount(), hddTotalCount(), powerTotalCount()};
		return severalTotalCount;
	}
	
	public int cpuTotalCount() {
		return dao.cpuTotalCount();
	}
	
	public int ramTotalCount() {
		return dao.ramTotalCount();
	}
	
	public int mainTotalCount() {
		return dao.mainTotalCount();
	}
	
	public int vgaTotalCount() {
		return dao.vgaTotalCount();
	}
	
	public int ssdTotalCount() {
		return dao.ssdTotalCount();
	}
	
	public int hddTotalCount() {
		return dao.hddTotalCount();
	}
	
	public int powerTotalCount() {
		return dao.powerTotalCount();
	}
}
