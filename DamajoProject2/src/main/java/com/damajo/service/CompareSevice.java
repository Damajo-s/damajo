package com.damajo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damajo.dao.CompareDAO;
import com.damajo.vo.CompareVO;
import com.damajo.vo.OverseasVO;

@Service
public class CompareSevice {
	@Autowired
	private CompareDAO dao;

	public List<CompareVO> compare(Map map) {
		List<CompareVO> compare=dao.compare(map);
		for(CompareVO vo:compare) {
			int product_no = vo.getProduct_no();
			int category_no = vo.getCategory_no();
			int price_no = vo.getPrice_no();
			String product_name=vo.getProduct_name();
			String price = vo.getPrice();
			String mall_name = vo.getMall_name();

			vo.setProduct_no(product_no);
			vo.setCategory_no(category_no);
			vo.setPrice_no(price_no);
			vo.setProduct_name(product_name);
			vo.setPrice(price);
			vo.setMall_name(mall_name);
		}
		return compare;
	}

	public List<OverseasVO> overseas(Map map) {
		List<OverseasVO> overseas=dao.overseascompare(map);
		for(OverseasVO vo:overseas) {
			int product_no = vo.getProduct_no();
			int category_no = vo.getCategory_no();
			int price_no = vo.getPrice_no();
			String product_name=vo.getProduct_name();
			String price = vo.getPrice();
			String mall_name = vo.getMall_name();

			vo.setProduct_no(product_no);
			vo.setCategory_no(category_no);
			vo.setPrice_no(price_no);
			vo.setProduct_name(product_name);
			vo.setPrice(price);
			vo.setMall_name(mall_name);
		}
		return overseas;
	}
}
