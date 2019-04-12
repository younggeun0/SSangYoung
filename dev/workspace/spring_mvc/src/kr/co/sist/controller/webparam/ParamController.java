package kr.co.sist.controller.webparam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.controller.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class ParamController {

	// GET������� ��û�� ó���� ������ URL�� �־ �ȴ�.
	@RequestMapping("/request_form.do")
	public String requestForm() {
		return "param/request_form";
	}
	
	// HttpServletRequest�� ����� �Ķ���� ó��
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
	
	// VO�� ����� Parameter ó��
	@RequestMapping(value="/vo_process.do",method=GET)
	public String voProcess(ParamVO pv, Model m) {
		// �� ���� JSP�� ���޵ȴ�.
		m.addAttribute("langData", pv.getLang());
		m.addAttribute("nameData", pv.getName());
		m.addAttribute("ageData",pv.getAge());
		return "param/vo_process";
	}
}
