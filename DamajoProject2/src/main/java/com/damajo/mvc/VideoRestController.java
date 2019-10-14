package com.damajo.mvc;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damajo.dao.VideoBoardDAO;
import com.damajo.vo.VideoBoardVO;

@RestController
public class VideoRestController {
	@Autowired
	private VideoBoardDAO vdao;
	//리스트출력
	@RequestMapping(value="tipboard/list_json.do",produces="application/json; charset=utf8")
	public String tipvoard_list_json(){
		String result="";
		List<VideoBoardVO> list = vdao.videoboard_list();
		VideoBoardVO vo=new VideoBoardVO();
		JSONArray arr= new JSONArray();
		JSONObject obj=new JSONObject();
		obj.put("no", vo.getNo());
		obj.put("title", vo.getTitle());
		obj.put("regdate", vo.getRegdate());
		obj.put("writer", vo.getWriter());
		obj.put("youtubekey",vo.getYoutubekey());
		arr.add(obj);
		result=arr.toJSONString();
		return result; 
	}
}
