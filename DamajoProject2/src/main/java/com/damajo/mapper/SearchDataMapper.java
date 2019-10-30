package com.damajo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.damajo.vo.ProductVO;

public interface SearchDataMapper {
	// 데이터 검색 (All=0)
	@Select("Select category,pno,pname,price,poster,num "
			+ "From (Select category,pno,pname,price,poster,rownum as num "
			+ "From (Select category,pno,pname,price,poster "
			+ "From product Where pname Like '%'||'${searchThis}'||'%' Order By pno asc)) "
			+ "Where num Between #{start} And #{end}")
	public List<ProductVO> searchAllDataList(Map map);
	@Select("Select Ceil(Count(*)/20) From product "
			+ "Where pname Like '%'||'${searchThis}'||'%'")
	public int searchAllDataTotalPage(ProductVO vo);
	@Select("Select Count(*) From product "
			+ "Where pname Like '%'||'${searchThis}'||'%'")
	public int searchAllDataTotalCount(ProductVO vo);
	
	// 데이터 검색 (Category=1~7)
	@Select("Select category,pno,pname,price,poster,num "
			+ "From (Select category,pno,pname,price,poster,rownum as num "
			+ "From (Select category,pno,pname,price,poster "
			+ "From product Where category=#{category} And pname Like '%'||'${searchThis}'||'%' Order By pno asc)) "
			+ "Where num Between 1 And 18")
	public List<ProductVO> searchCategoryDataList(Map map);
	@Select("Select Ceil(Count(*)/20) From product "
			+ "Where category=#{category} And pname Like '%'||'${searchThis}'||'%'")
	public int searchCategoryDataTotalPage(ProductVO vo);
	@Select("Select Count(*) From product "
			+ "Where category=#{category} And pname Like '%'||'${searchThis}'||'%'")
	public int searchCategoryDataTotalCount(ProductVO vo);
}
