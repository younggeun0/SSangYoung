package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.CookieService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {
	
	@RequestMapping(value="/cookie/read_an_cookie.do",method=GET)
	public String anReadCookie(
		@CookieValue(value="an_name", defaultValue="")String an_name,
		@CookieValue(value="an_age", defaultValue="")String an_age, Model model) {
		
		model.addAttribute("an_name", an_name);
		model.addAttribute("an_age", an_age);
		
		return "cookie/an_read_cookie";
	}
	
	@RequestMapping(value="/cookie/an_add_cookie.do",method=GET)
	public String anAddCookie(HttpServletResponse response) {
		
		// 1. ��Ű ����
		Cookie nameCookie = new Cookie("an_name","jungyun");
		Cookie ageCookie = new Cookie("an_age", "30");
		
		// 2. ��Ű �����ð� ����
		nameCookie.setMaxAge(60*60);
		ageCookie.setMaxAge(60*60);
		
		// 3. ��Ű �ɱ�
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		return "cookie/an_read_result";
	}
	
	@RequestMapping(value="/cookie/add_cookie.do",method=GET)
	public String addCookie(HttpServletResponse response, Model model) {
		
		// 1. ��Ű ����
		Cookie nameCookie = new Cookie("name","seonui.gong");
		Cookie ageCookie = new Cookie("age", "28");
		
		// 2. ��Ű �����ð� ����
		nameCookie.setMaxAge(60*2);
		ageCookie.setMaxAge(60*2);
		
		// 3. ��Ű �ɱ�
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag",true);
		model.addAttribute("msg","��Ű�� �ɾ������ϴ�.");
		
		return "cookie/read_cookie";
	}
	
	@RequestMapping(value="/cookie/remove_cookie.do",method=GET)
	public String removeCookie(HttpServletResponse response, Model model) {
		
		// 1. ���� �̸��� ��Ű�� �����Ѵ�.
		Cookie nameCookie = new Cookie("name", "");
		Cookie ageCookie = new Cookie("age", "");
		
		// 2. �����ð��� 0���� ����
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		
		// 3. ��Ű�� �ɴ´�.
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg","��Ű�� ���ŵǾ����ϴ�.");
		
		return "cookie/read_cookie";
	}

	@RequestMapping(value="/cookie/read_cookie.do",method=GET)
	public String readCookie(HttpServletRequest request, Model model) {
		
		// ��Ű�� �б�
		Cookie[] cookies = request.getCookies();
		// �о���� ��� ��Ű�� JSP���� ����� �� �ִ�
		
		if(cookies != null) { // �о���� ��Ű�� ����
			model.addAttribute("rCookie",cookies);  
			CookieService cs = new CookieService();
			Cookie tempCookie = null;
			int cnt = 0;
			for(int i=0; i<cookies.length; i++) { 
				// Controller���� ��Ű�� ������ ����ó���� �ϱ� ���ؼ� ���� ��� ��
				tempCookie = cookies[i];
				if("JSESSIONID".equals(tempCookie.getName())){
					cnt++;
				}
				if("name".equals(tempCookie.getName())){
					model.addAttribute("name", 
						cs.nameMsg(tempCookie.getValue()));
					cnt++;
				}
				if("age".equals(tempCookie.getName())){
					model.addAttribute("birth", 
						cs.birth(Integer.parseInt(
							tempCookie.getValue())));
				}
			}
			
			if (cnt == 1) // JSESSIONID�� �����ϴ� ���
				model.addAttribute("rCookie",null);
		}
		return "cookie/read_cookie";
	}
}
