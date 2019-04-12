package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {

	@RequestMapping(value="/index.do",method=GET)
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping(value="/request_get.do",method=GET)
	public String requestGet() {
		return "get";
	}
	
	@RequestMapping(value="/request_post.do",method=POST)
	public String requestPost() {
		return "post";
	}
	
	// 하나의 요청(method)처리 method가 GET/POST 방식을 모두 처리해야 할 때
	// method를 배열로 처리한다. method={ GET, POST }
	@RequestMapping(value="/request_all.do",method={ GET, POST })
	public String requestAll() {
		return "all";
	}
}	
