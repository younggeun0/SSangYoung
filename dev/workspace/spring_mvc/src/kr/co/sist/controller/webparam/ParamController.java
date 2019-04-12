package kr.co.sist.controller.webparam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.controller.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class ParamController {

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
