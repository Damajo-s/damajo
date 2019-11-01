package com.damajo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.dao.DetailDAO;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Repository
public class DetailService {
	@Autowired
	private DetailDAO dao;

	public CpuVO cpuContentsDetail(Map map) {
		return dao.CpuDetail(map);
	}
	public RamVO ramContentsDetail(Map map){
		return dao.RamDetail(map);
	}
	public MainVO mainContentsDetail(Map map){
		return dao.MainDetail(map);
	}
	public VgaVO vgaContentsDetail(Map map){
		return dao.VgaDetail(map);
	}
	public SsdVO ssdContentsDetail(Map map){
		return dao.SsdDetail(map);
	}
	public HddVO hddContentsDetail(Map map){
		return dao.HddDetail(map);
	}
	public PowerVO powerContentsDetail(Map map){
		return dao.PowerDetail(map);
	}
}
