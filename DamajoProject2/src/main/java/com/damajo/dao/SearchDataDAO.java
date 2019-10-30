package com.damajo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damajo.mapper.SearchDataMapper;
import com.damajo.vo.ProductVO;

@Repository
public class SearchDataDAO {
	@Autowired
	private SearchDataMapper mapper;
	
	// 전체 검색
	public List<ProductVO> searchAllDataList(Map map) {
		return mapper.searchAllDataList(map);
	}
	// 전체 검색 페이지 개수
	public int searchAllDataTotalPage(ProductVO vo) {
		return mapper.searchAllDataTotalPage(vo);
	}
	// 전체 검색 데이터 개수
	public int searchAllDataTotalCount(ProductVO vo) {
		return mapper.searchAllDataTotalCount(vo);
	}
	
	// 카테고리 분류 검색
	public List<ProductVO> searchCategoryDataList(Map map) {
		return mapper.searchCategoryDataList(map);
	}
	// 카테고리 분류 페이지 개수
	public int searchCategoryDataTotalPage(ProductVO vo) {
		return mapper.searchCategoryDataTotalPage(vo);
	}
	// 카테고리 분류 데이터 개수
	public int searchCategoryDataTotalCount(ProductVO vo) {
		return mapper.searchCategoryDataTotalCount(vo);
	}
}
