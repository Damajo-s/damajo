package com.damajo.dao;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.CPU_DetailMapper;
import com.damajo.vo.CPUVO;


@Repository
public class CPU_DetailDAO {
	@Autowired
	private  CPU_DetailMapper mapper;

	   public CPUVO CPU_Detail(int no)
	   {
		   return mapper.CPU_Detail(no);
	   }
}
