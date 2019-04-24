package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.JdbcService;

@Controller
public class JdbcController {

	@Autowired
	private JdbcService js;
	
	@RequestMapping("index.do")
	private String test() {
		js.daoPrint();
		return "test";
	}
}
