package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.service.OrmService;

@Controller
public class OrmController {
	
	@Autowired(required = false)
	private OrmService os;

	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String test() {
		os.test();
		return "test";
	}
	
}
