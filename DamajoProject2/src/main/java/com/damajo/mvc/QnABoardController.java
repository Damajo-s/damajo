package com.damajo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.damajo.dao.QABoardDAO;

@Controller
public class QnABoardController {
	@Autowired
	private QABoardDAO qdao;
	
}
