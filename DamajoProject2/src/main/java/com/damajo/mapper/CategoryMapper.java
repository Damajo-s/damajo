package com.damajo.mapper;

import org.apache.ibatis.annotations.Select;
import com.damajo.vo.CategoryVO;
import java.util.*;

public interface CategoryMapper {
	
	// 카테고리 리스트 가져오기
	@Select("Select * From category")
	public List<CategoryVO> category();
}
