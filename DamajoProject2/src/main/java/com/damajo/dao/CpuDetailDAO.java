package com.damajo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.CpuDetailMapper;
import com.damajo.vo.CpuVO;

@Repository
public class CpuDetailDAO {
	@Autowired
	private CpuDetailMapper mapper;

	public CpuVO CpuDetail(int no) {
		return mapper.CpuDetail(no);
	}
}
