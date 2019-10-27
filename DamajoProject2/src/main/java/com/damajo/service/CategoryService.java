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
		int[] severalTotalCount={dao.cpuTotalCount(), dao.ramTotalCount(), dao.mainTotalCount(), dao.vgaTotalCount(),
								dao.ssdTotalCount(), dao.hddTotalCount(), dao.powerTotalCount()};
		return severalTotalCount;
	}
}
