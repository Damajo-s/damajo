package com.damajo.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damajo.dao.QABoardDAO;
import com.damajo.service.CompareSevice;
import com.damajo.service.DetailService;
import com.damajo.vo.CompareVO;
import com.damajo.vo.CpuVO;
import com.damajo.vo.HddVO;
import com.damajo.vo.MainVO;
import com.damajo.vo.PowerVO;
import com.damajo.vo.QABoardVO;
import com.damajo.vo.RamVO;
import com.damajo.vo.SsdVO;
import com.damajo.vo.VgaVO;

@Controller
public class QnABoardController {
	@Autowired
	private QABoardDAO qdao;
	@Autowired
	private DetailService service;
	@Autowired
	private CompareSevice service2;

	// 상품 Q&A 작성하기 창 띄우기
	@RequestMapping("shop/qainsert.do")
	public String shop_qainsert(String no,String category,Model model, HttpSession session){
		//System.out.println(no);
		//System.out.println(category);
		String id=(String)session.getAttribute("id");
		model.addAttribute("id", id);
		model.addAttribute("no", no);
		model.addAttribute("category", category);
		return "qainsert";
	}
	// QA새글
	@RequestMapping("shop/qainsert_ok.do")
	public String cpu_insert(String no,String category,String subject,String content, Model model, HttpSession session) {
/*		System.out.println("상품"+no);
		System.out.println("카테고리"+category);
		System.out.println(subject);
		System.out.println(content);*/
		QABoardVO vo = new QABoardVO();
		//String id = "sj6239@naver.com";
		String id=(String) session.getAttribute("id");
		vo.setId(id);
		vo.setPno(Integer.parseInt(no));
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setAdminres("답변 대기중입니다.");
		vo.setCategory(Integer.parseInt(category));
		qdao.qaboardInsert(vo);
		model.addAttribute("no", no);
		model.addAttribute("category", category);

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
	// 해당 상품게시물 총 수
	// Q&A 리스트
	@RequestMapping("shop/cpu_detail.do")
	public String cpu_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		System.out.println("상품"+no);
		System.out.println("카테고리"+category);
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		System.out.println(qPnoCount);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		CpuVO cpudetail=service.cpuContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		/*
		 * System.out.println("1상품번호:"+no);
		 * System.out.println("1카테고리번호:"+category);
		 */
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("cpudetail", cpudetail);
		model.addAttribute("compare", compare);
		return "shop/cpu_detail";
	}
	@RequestMapping("shop/cpu_detail_page.do")
	public String cpu_detail_page(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		System.out.println("상품"+no);
		System.out.println("카테고리"+category);
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
				int curPage = Integer.parseInt(page);
				int totalPage = qdao.qaboardTotal(no,category);
				int qPnoCount=qdao.qaboardPnoCount(no,category);
				int BLOCK=5;
				int startPage=((curPage-1)/BLOCK*BLOCK)+1;
				int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
				int allPage = totalPage;
				if(endPage > allPage){
					endPage=allPage;
				}
				List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
				CpuVO cpudetail=service.cpuContentsDetail(map);
				List<CompareVO> compare=service2.compare(map);
				System.out.println("2상품번호:"+no);
				System.out.println("2카테고리번호:"+category);
				model.addAttribute("qPnoCount", qPnoCount);
				model.addAttribute("curPage", curPage);
				model.addAttribute("totalPage", totalPage);
				model.addAttribute("BLOCK", BLOCK);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("allPage", allPage);
				model.addAttribute("list", list);
				model.addAttribute("product", no);
				model.addAttribute("category", category);
				model.addAttribute("cpudetail", cpudetail);
				model.addAttribute("compare", compare);
				return "detail_page";
		}
	@RequestMapping("shop/ram_detail.do")
	public String ram_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<RamVO> ramdetail=service.ramContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("ramdetail", ramdetail);
		model.addAttribute("compare", compare);
		return "shop/ram_detail";
	}
	@RequestMapping("shop/ram_detail_page.do")
	public String ram_detail_page(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<RamVO> ramdetail=service.ramContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("ramdetail", ramdetail);
		model.addAttribute("compare", compare);
		return "detail_page";
	}
	@RequestMapping("shop/main_detail.do")
	public String main_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<MainVO> maindetail=service.mainContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("maindetail", maindetail);
		model.addAttribute("compare", compare);
		return "shop/main_detail";
	}
	@RequestMapping("shop/main_detail_page.do")
	public String main_detail_pgae(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<MainVO> maindetail=service.mainContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("maindetail", maindetail);
		model.addAttribute("compare", compare);
		return "detail_page";
	}
	@RequestMapping("shop/vga_detail.do")
	public String vga_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<VgaVO> vgadetail=service.vgaContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("vgadetail", vgadetail);
		model.addAttribute("compare", compare);
		return "shop/vga_detail";
	}
	@RequestMapping("shop/vga_detail_page.do")
	public String vga_detail_page(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<VgaVO> vgadetail=service.vgaContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("vgadetail", vgadetail);
		model.addAttribute("compare", compare);
		return "detail_page";
	}
	@RequestMapping("shop/ssd_detail.do")
	public String ssd_detail(String page, int no,int category,Model model,HttpSession session){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<SsdVO> ssddetail=service.ssdContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("ssddetail", ssddetail);
		model.addAttribute("compare", compare);
		return "shop/ssd_detail";
	}
	@RequestMapping("shop/ssd_detail_page.do")
	public String ssd_detail_page(String page, int no,int category,Model model,HttpSession session){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<SsdVO> ssddetail=service.ssdContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("ssddetail", ssddetail);
		model.addAttribute("compare", compare);
		return "detail_page";
	}
	@RequestMapping("shop/hdd_detail.do")
	public String hdd_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<HddVO> hdddetail=service.hddContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("hdddetail", hdddetail);
		model.addAttribute("compare", compare);
		return "shop/hdd_detail";
	}
	@RequestMapping("shop/hdd_detail_page.do")
	public String hdd_detail_page(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<HddVO> hdddetail=service.hddContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("hdddetail", hdddetail);
		model.addAttribute("compare", compare);
		return "detail_page";
	}
	@RequestMapping("shop/power_detail.do")
	public String power_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<PowerVO> powerdetail=service.powerContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("powerdetail", powerdetail);
		model.addAttribute("compare", compare);
		return "shop/power_detail";
	}
	@RequestMapping("shop/power_detail_page.do")
	public String power_detail_page(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal(no,category);
		int qPnoCount=qdao.qaboardPnoCount(no,category);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no,category);
		List<PowerVO> powerdetail=service.powerContentsDetail(map);
		List<CompareVO> compare=service2.compare(map);
		//System.out.println("처음:"+curPage);
		//System.out.println("처음:"+product);
		model.addAttribute("qPnoCount", qPnoCount);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("list", list);
		model.addAttribute("product", no);
		model.addAttribute("category", category);
		model.addAttribute("powerdetail", powerdetail);
		model.addAttribute("compare", compare);
		return "detail_page";
	}

}
