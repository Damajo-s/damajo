package com.damajo.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damajo.dao.ContentsDAO;
import com.damajo.vo.CPUVO;
import com.damajo.vo.HDDVO;
import com.damajo.vo.MAINVO;
import com.damajo.vo.RAMVO;
import com.damajo.vo.SSDVO;
import com.damajo.vo.VGAVO;

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
	
	public List<RAMVO> ramContentsList(Map map) {
		List<RAMVO> ramList=dao.ramContentsList(map);
		for(RAMVO vo:ramList) {
			String ram_name=vo.getRam_name();
			if(ram_name.length()>43) {
				ram_name=ram_name.substring(0,42)+"...";
				vo.setRam_name(ram_name);
			}
		}
		return ramList;
	}
	public int ramTotalPage() {
		return dao.ramTotalPage();
	}
	
	public List<MAINVO> mainContentsList(Map map) {
		List<MAINVO> mainList=dao.mainContentsList(map);
		for(MAINVO vo:mainList) {
			String main_name=vo.getMain_name();
			if(main_name.length()>43) {
				main_name=main_name.substring(0,42)+"...";
				vo.setMain_name(main_name);
			}
		}
		return mainList;
	}
	public int mainTotalPage() {
		return dao.mainTotalPage();
	}
	
	public List<VGAVO> vgaContentsList(Map map) {
		List<VGAVO> vgaList=dao.vgaContentsList(map);
		for(VGAVO vo:vgaList) {
			String vga_name=vo.getVga_name();
			if(vga_name.length()>43) {
				vga_name=vga_name.substring(0,42)+"...";
				vo.setVga_name(vga_name);
			}
		}
		return vgaList;
	}
	public int vgaTotalPage() {
		return dao.vgaTotalPage();
	}
	
	public List<SSDVO> ssdContentsList(Map map) {
		List<SSDVO> ssdList=dao.ssdContentsList(map);
		for(SSDVO vo:ssdList) {
			String ssd_name=vo.getSsd_name();
			if(ssd_name.length()>43) {
				ssd_name=ssd_name.substring(0,42)+"...";
				vo.setSsd_name(ssd_name);
			}
		}
		return ssdList;
	}
	public int ssdTotalPage() {
		return dao.ssdTotalPage();
	}
	
	public List<HDDVO> hddContentsList(Map map) {
		List<HDDVO> hddList=dao.hddContentsList(map);
		for(HDDVO vo:hddList) {
			String hdd_name=vo.getHdd_name();
			if(hdd_name.length()>43) {
				hdd_name=hdd_name.substring(0,42)+"...";
				vo.setHdd_name(hdd_name);
			}
		}
		return hddList;
	}
	public int hddTotalPage() {
		return dao.hddTotalPage();
	}
}
