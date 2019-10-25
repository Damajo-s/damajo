package com.damajo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damajo.dao.ContentsDAO;
import com.damajo.vo.CPUVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;

@Service
public class ContentsService {
	@Autowired
	private ContentsDAO dao;
	
	public List<CPUVO> cpuContentsList(Map map) {
		List<CPUVO> cpuList=dao.cpuContentsList(map);
		for(CPUVO vo:cpuList) {
			String cpu_name=vo.getCpu_name();
			if(cpu_name.length()>43) {
				cpu_name=cpu_name.substring(0,42)+"...";
				vo.setCpu_name(cpu_name);
			}
		}
		return cpuList;
	}
	public int cpuTotalPage() {
		return dao.cpuTotalPage();
	}
	
	public List<RAMVO> ramContentsList() {
		List<RAMVO> ramList=dao.ramContentsList();
		for(RAMVO vo:ramList) {
			String ram_name=vo.getRam_name();
			if(ram_name.length()>43) {
				ram_name=ram_name.substring(0,42)+"...";
				vo.setRam_name(ram_name);
			}
		}
		return ramList;
	}
	
	public List<MAINVO> mainContentsList() {
		List<MAINVO> mainList=dao.mainContentsList();
		for(MAINVO vo:mainList) {
			String main_name=vo.getMain_name();
			if(main_name.length()>43) {
				main_name=main_name.substring(0,42)+"...";
				vo.setMain_name(main_name);
			}
		}
		return mainList;
	}
}
