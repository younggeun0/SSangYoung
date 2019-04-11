package kr.co.sist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do",method=RequestMethod.GET)
	public String hello() {
		
		System.out.println("Hello Spring");
		return "hello";
	}
}
