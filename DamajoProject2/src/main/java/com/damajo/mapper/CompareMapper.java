package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.damajo.vo.CompareVO;

public interface CompareMapper {

	@Select("Select * From compareprice "
			+ "WHERE product_no = #{no} and category_no=#{category}")
	public List<CompareVO> Compare(Map map);

}
