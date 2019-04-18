package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;


@Controller
public class ParamController {
	
	@RequestMapping(value="/request_int.do", method=RequestMethod.GET)
	public String requestInt(@RequestParam(name="age", defaultValue="1",
		required=false) int age, Model m) {
		m.addAttribute("age", age+"살");
		
		return "param/request_int";
	}
	
	@RequestMapping(value="/request_string.do", method=RequestMethod.GET)
	public String requestString(@RequestParam(defaultValue="anonymous") String name, Model m) {
		// 단일형으로 매개변수를 받을 때에는 web parameter명(HTML form control명)과 
		// method의 매개변수명이 같아야 한다.
		
		/*if (name == null || "".equals(name)) { // 파라미터 자체가 없거나, 값이 없을 때
			name = "Guest"; // 
		}*/
		m.addAttribute("name", name+"님 안녕하세요?");
		
		return "param/request_string";
	}

	// GET방식으로 요청을 처리할 때에는 URL만 넣어도 된다.
	@RequestMapping("/request_form.do")
	public String requestForm() {
		return "param/request_form";
	}
	
	// HttpServletRequest를 사용한 파라미터 처리
	@RequestMapping(value="/use_request_process.do",method=GET)
	public String requestFormProcess(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] lang = request.getParameterValues("lang");
		
		request.setAttribute("lang",lang);
		
		return "param/request_process";
	}
	
	@RequestMapping(value="/vo_form.do",method=GET)
	public String voForm() {
		return "param/vo_form";
	}
	
	// VO를 사용한 Parameter 처리
	@RequestMapping(value="/vo_process.do",method=GET)
	public String voProcess(ParamVO pv, Model m) {
		// 이 값은 JSP로 전달된다.
		m.addAttribute("langData", pv.getLang());
		m.addAttribute("nameData", pv.getName());
		m.addAttribute("ageData",pv.getAge());
		return "param/vo_process";
	}
}
