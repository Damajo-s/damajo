package com.damajo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.DetailMapper;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Repository
public class DetailDAO {
	@Autowired
	private DetailMapper mapper;

	public CpuVO CpuDetail(Map map) {
		return mapper.CpuDetail(map);
	}
	public RamVO RamDetail(Map map) {
		return mapper.RamDetail(map);
	}
	public MainVO MainDetail(Map map) {
		return mapper.MainDetail(map);
	}
	public VgaVO VgaDetail(Map map) {
		return mapper.VgaDetail(map);
	}
	public SsdVO SsdDetail(Map map) {
		return mapper.SsdDetail(map);
	}
	public HddVO HddDetail(Map map) {
		return mapper.HddDetail(map);
	}
	public PowerVO PowerDetail(Map map) {
		return mapper.PowerDetail(map);
	}
}
