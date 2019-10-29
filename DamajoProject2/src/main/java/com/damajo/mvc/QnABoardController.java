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
	// QA새글
	@RequestMapping("shop/qainsert_ok.do")
	public String shop_insert(int product,String subject,String content, Model model, HttpSession session) {
		// 아이디 비밀번호 session에서 처리?
		QABoardVO vo = new QABoardVO();
		//String id = "sj6239@naver.com";
		String id=(String) session.getAttribute("id");
		int category = 1;
		vo.setId(id);
		vo.setPno(product);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setAdminres("답변 대기중입니다.");
		vo.setCategory(category);
		System.out.println(product);
		System.out.println(subject);
		System.out.println(content);
		qdao.qaboardInsert(vo);
		model.addAttribute("product", product);
		return "redirect:detail.do";
	}
	// 해당 상품게시물 총 수
	// Q&A 리스트
	@RequestMapping("shop/cpu_detail.do")
	public String cpu_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
		List<CpuVO> cpudetail=service.cpuContentsDetail(map);
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
		model.addAttribute("cpudetail", cpudetail);
		model.addAttribute("compare", compare);
		return "shop/cpu_detail";
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
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
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
		model.addAttribute("ramdetail", ramdetail);
		model.addAttribute("compare", compare);
		return "shop/ram_detail";
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
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
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
		model.addAttribute("maindetail", maindetail);
		model.addAttribute("compare", compare);
		return "shop/main_detail";
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
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
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
		model.addAttribute("vgadetail", vgadetail);
		model.addAttribute("compare", compare);
		return "shop/vga_detail";
	}
	@RequestMapping("shop/ssd_detail.do")
	public String ssd_detail(String page, int no,int category,Model model){
		if (page == null) {
			page = "1";
		}
		Map map=new HashMap();
		map.put("no", no);
		map.put("category", category);
		//페이지
		int curPage = Integer.parseInt(page);
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
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
		model.addAttribute("ssddetail", ssddetail);
		model.addAttribute("compare", compare);
		return "shop/ssd_detail";
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
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
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
		model.addAttribute("hdddetail", hdddetail);
		model.addAttribute("compare", compare);
		return "shop/hdd_detail";
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
		int totalPage = qdao.qaboardTotal();
		int qPnoCount=qdao.qaboardPnoCount(no);
		int BLOCK=5;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		int allPage = totalPage;
		if(endPage > allPage){
			endPage=allPage;
		}
		List<QABoardVO> list= qdao.qaboardList(curPage,no);
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
		model.addAttribute("powerdetail", powerdetail);
		model.addAttribute("compare", compare);
		return "shop/power_detail";
	}
	// Q&A 리스트
		@RequestMapping("shop/detail_page.do")
		public String shop_detail_page(String page, int product,Model model){
			if (page == null) {
				page = "1";
			}
			//페이지
			int curPage = Integer.parseInt(page);
			int totalPage = qdao.qaboardTotal();
			int qPnoCount=qdao.qaboardPnoCount(product);
			int BLOCK=5;
			int startPage=((curPage-1)/BLOCK*BLOCK)+1;
			int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
			int allPage = totalPage;
			if(endPage > allPage){
				endPage=allPage;
			}
			List<QABoardVO> list= qdao.qaboardList(curPage,product);
			//System.out.println("두번:"+curPage);
			//System.out.println("두번:"+product);
			model.addAttribute("qPnoCount", qPnoCount);
			model.addAttribute("curPage", curPage);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("BLOCK", BLOCK);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("allPage", allPage);
			model.addAttribute("list", list);
			model.addAttribute("product", product);
			return "detail_page";
		}
}
