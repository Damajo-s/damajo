package com.damajo.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.dao.ReviewDAO;
import com.damajo.service.ReviewService;
import com.damajo.vo.ReviewVO;

@Controller
public class ReviewController {
	@Autowired
	private ReviewDAO rdao;
	@Autowired
	private ReviewService rs;

	//추가
	@RequestMapping("shop/cpu_detail_reviewInsert.do")
	public String reviewInsert(String no, String category, String subject,String content,Model model,HttpSession session){
		ReviewVO vo = new ReviewVO();
		String id=(String)session.getAttribute("id");
		vo.setId(id);
		vo.setR_pno(Integer.parseInt(no));
		vo.setR_subject(subject);
		vo.setR_content(content);
		vo.setCategory(Integer.parseInt(category));
		rs.reviewInsert(vo);
		model.addAttribute("no", no);
		model.addAttribute("category", category);
		model.addAttribute("id", id);

		if(category.equals("1")){
			return "redirect:cpu_detail.do";
		}else if(category.equals("2")){
			return "redirect:ram_detail.do";
		}else if(category.equals("3")){
			return "redirect:main_detail.do";
		}else if(category.equals("4")){
			return "redirect:vga_detail.do";
		}else if(category.equals("5")){
			return "redirect:ssd_detail.do";
		}else if(category.equals("6")){
			return "redirect:hdd_detail.do";
		}else {
			return "redirect:power_detail.do";
		}
	}
		//리스트출력
		@RequestMapping("shop/cpu_detail_reviewpage2.do")
		public String cpuReviewList(String page,int no,int category,Model model){
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			int rowSize=5;
			int start=(curpage*rowSize)-(rowSize-1);
			int end=curpage*rowSize;
			Map map = new HashMap();
			map.put("no", no);
			map.put("category", category);
			map.put("start", start);
			map.put("end", end);

			System.out.println("상품번호:"+no);
			System.out.println("카테고리"+category);
			int curPage = Integer.parseInt(page);
			System.out.println(curPage);
			int totalPage =rs.reviewTotal();
			System.out.println("총페이지"+totalPage);
			int BLOCK=5;
			int startPage=((curPage-1)/BLOCK*BLOCK)+1;
			int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
			int allPage = totalPage;
			if(endPage > allPage){
				endPage=allPage;
			}
			System.out.println("페이지:"+curPage);
			System.out.println("스타트페지"+startPage);
			System.out.println("endPage:"+endPage);
			System.out.println("allPage:"+allPage);
			System.out.println("스타트페지"+startPage);
			List<ReviewVO> rlist= rs.reviewList(map);
			model.addAttribute("product", no);
			model.addAttribute("rlist", rlist);
			model.addAttribute("curPage", curPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("allPage", allPage);
			return "review_page";
		}
		//리스트출력
				@RequestMapping("shop/hdd_detail_reviewpage2.do")
				public String hddReviewList(String page,int no,int category,Model model){
					if(page==null) {
						page="1";
					}
					int curpage=Integer.parseInt(page);
					int rowSize=5;
					int start=(curpage*rowSize)-(rowSize-1);
					int end=curpage*rowSize;
					Map map = new HashMap();
					map.put("no", no);
					map.put("category", category);
					map.put("start", start);
					map.put("end", end);

					System.out.println("상품번호:"+no);
					System.out.println("카테고리"+category);
					int curPage = Integer.parseInt(page);
					System.out.println(curPage);
					int totalPage =rs.reviewTotal();
					System.out.println("총페이지"+totalPage);
					int BLOCK=5;
					int startPage=((curPage-1)/BLOCK*BLOCK)+1;
					int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
					int allPage = totalPage;
					if(endPage > allPage){
						endPage=allPage;
					}
					System.out.println("페이지:"+curPage);
					System.out.println("스타트페지"+startPage);
					System.out.println("endPage:"+endPage);
					System.out.println("allPage:"+allPage);
					System.out.println("스타트페지"+startPage);
					List<ReviewVO> rlist= rs.reviewList(map);
					model.addAttribute("product", no);
					model.addAttribute("rlist", rlist);
					model.addAttribute("curPage", curPage);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("allPage", allPage);
					return "review_page";
				}
				//리스트출력
				@RequestMapping("shop/main_detail_reviewpage2.do")
				public String mainReviewList(String page,int no,int category,Model model){
					if(page==null) {
						page="1";
					}
					int curpage=Integer.parseInt(page);
					int rowSize=5;
					int start=(curpage*rowSize)-(rowSize-1);
					int end=curpage*rowSize;
					Map map = new HashMap();
					map.put("no", no);
					map.put("category", category);
					map.put("start", start);
					map.put("end", end);

					System.out.println("상품번호:"+no);
					System.out.println("카테고리"+category);
					int curPage = Integer.parseInt(page);
					System.out.println(curPage);
					int totalPage =rs.reviewTotal();
					System.out.println("총페이지"+totalPage);
					int BLOCK=5;
					int startPage=((curPage-1)/BLOCK*BLOCK)+1;
					int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
					int allPage = totalPage;
					if(endPage > allPage){
						endPage=allPage;
					}
					System.out.println("페이지:"+curPage);
					System.out.println("스타트페지"+startPage);
					System.out.println("endPage:"+endPage);
					System.out.println("allPage:"+allPage);
					System.out.println("스타트페지"+startPage);
					List<ReviewVO> rlist= rs.reviewList(map);
					model.addAttribute("product", no);
					model.addAttribute("rlist", rlist);
					model.addAttribute("curPage", curPage);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("allPage", allPage);
					return "review_page";
				}
				//리스트출력
				@RequestMapping("shop/power_detail_reviewpage2.do")
				public String powerReviewList(String page,int no,int category,Model model){
					if(page==null) {
						page="1";
					}
					int curpage=Integer.parseInt(page);
					int rowSize=5;
					int start=(curpage*rowSize)-(rowSize-1);
					int end=curpage*rowSize;
					Map map = new HashMap();
					map.put("no", no);
					map.put("category", category);
					map.put("start", start);
					map.put("end", end);

					System.out.println("상품번호:"+no);
					System.out.println("카테고리"+category);
					int curPage = Integer.parseInt(page);
					System.out.println(curPage);
					int totalPage =rs.reviewTotal();
					System.out.println("총페이지"+totalPage);
					int BLOCK=5;
					int startPage=((curPage-1)/BLOCK*BLOCK)+1;
					int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
					int allPage = totalPage;
					if(endPage > allPage){
						endPage=allPage;
					}
					System.out.println("페이지:"+curPage);
					System.out.println("스타트페지"+startPage);
					System.out.println("endPage:"+endPage);
					System.out.println("allPage:"+allPage);
					System.out.println("스타트페지"+startPage);
					List<ReviewVO> rlist= rs.reviewList(map);
					model.addAttribute("product", no);
					model.addAttribute("rlist", rlist);
					model.addAttribute("curPage", curPage);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("allPage", allPage);
					return "review_page";
				}
				//리스트출력
				@RequestMapping("shop/ram_detail_reviewpage2.do")
				public String ramReviewList(String page,int no,int category,Model model){
					if(page==null) {
						page="1";
					}
					int curpage=Integer.parseInt(page);
					int rowSize=5;
					int start=(curpage*rowSize)-(rowSize-1);
					int end=curpage*rowSize;
					Map map = new HashMap();
					map.put("no", no);
					map.put("category", category);
					map.put("start", start);
					map.put("end", end);

					System.out.println("상품번호:"+no);
					System.out.println("카테고리"+category);
					int curPage = Integer.parseInt(page);
					System.out.println(curPage);
					int totalPage =rs.reviewTotal();
					System.out.println("총페이지"+totalPage);
					int BLOCK=5;
					int startPage=((curPage-1)/BLOCK*BLOCK)+1;
					int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
					int allPage = totalPage;
					if(endPage > allPage){
						endPage=allPage;
					}
					System.out.println("페이지:"+curPage);
					System.out.println("스타트페지"+startPage);
					System.out.println("endPage:"+endPage);
					System.out.println("allPage:"+allPage);
					System.out.println("스타트페지"+startPage);
					List<ReviewVO> rlist= rs.reviewList(map);
					model.addAttribute("product", no);
					model.addAttribute("rlist", rlist);
					model.addAttribute("curPage", curPage);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("allPage", allPage);
					return "review_page";
				}
				//리스트출력
				@RequestMapping("shop/ssd_detail_reviewpage2.do")
				public String ssdReviewList(String page,int no,int category,Model model){
					if(page==null) {
						page="1";
					}
					int curpage=Integer.parseInt(page);
					int rowSize=5;
					int start=(curpage*rowSize)-(rowSize-1);
					int end=curpage*rowSize;
					Map map = new HashMap();
					map.put("no", no);
					map.put("category", category);
					map.put("start", start);
					map.put("end", end);

					System.out.println("상품번호:"+no);
					System.out.println("카테고리"+category);
					int curPage = Integer.parseInt(page);
					System.out.println(curPage);
					int totalPage =rs.reviewTotal();
					System.out.println("총페이지"+totalPage);
					int BLOCK=5;
					int startPage=((curPage-1)/BLOCK*BLOCK)+1;
					int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
					int allPage = totalPage;
					if(endPage > allPage){
						endPage=allPage;
					}
					System.out.println("페이지:"+curPage);
					System.out.println("스타트페지"+startPage);
					System.out.println("endPage:"+endPage);
					System.out.println("allPage:"+allPage);
					System.out.println("스타트페지"+startPage);
					List<ReviewVO> rlist= rs.reviewList(map);
					model.addAttribute("product", no);
					model.addAttribute("rlist", rlist);
					model.addAttribute("curPage", curPage);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("allPage", allPage);
					return "review_page";
				}
				//리스트출력
				@RequestMapping("shop/vga_detail_reviewpage2.do")
				public String vgaReviewList(String page,int no,int category,Model model){
					if(page==null) {
						page="1";
					}
					int curpage=Integer.parseInt(page);
					int rowSize=5;
					int start=(curpage*rowSize)-(rowSize-1);
					int end=curpage*rowSize;
					Map map = new HashMap();
					map.put("no", no);
					map.put("category", category);
					map.put("start", start);
					map.put("end", end);

					System.out.println("상품번호:"+no);
					System.out.println("카테고리"+category);
					int curPage = Integer.parseInt(page);
					System.out.println(curPage);
					int totalPage =rs.reviewTotal();
					System.out.println("총페이지"+totalPage);
					int BLOCK=5;
					int startPage=((curPage-1)/BLOCK*BLOCK)+1;
					int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
					int allPage = totalPage;
					if(endPage > allPage){
						endPage=allPage;
					}
					System.out.println("페이지:"+curPage);
					System.out.println("스타트페지"+startPage);
					System.out.println("endPage:"+endPage);
					System.out.println("allPage:"+allPage);
					System.out.println("스타트페지"+startPage);
					List<ReviewVO> rlist= rs.reviewList(map);
					model.addAttribute("product", no);
					model.addAttribute("rlist", rlist);
					model.addAttribute("curPage", curPage);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("allPage", allPage);
					return "review_page";
				}
				
	}




