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
		m.addAttribute("age", age+"��");
		
		return "param/request_int";
	}
	
	@RequestMapping(value="/request_string.do", method=RequestMethod.GET)
	public String requestString(@RequestParam(defaultValue="anonymous") String name, Model m) {
		// ���������� �Ű������� ���� ������ web parameter��(HTML form control��)�� 
		// method�� �Ű��������� ���ƾ� �Ѵ�.
		
		/*if (name == null || "".equals(name)) { // �Ķ���� ��ü�� ���ų�, ���� ���� ��
			name = "Guest"; // 
		}*/
		m.addAttribute("name", name+"�� �ȳ��ϼ���?");
		
		return "param/request_string";
	}

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
