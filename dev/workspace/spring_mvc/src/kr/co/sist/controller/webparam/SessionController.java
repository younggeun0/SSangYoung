package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.controller.vo.SessionVO;

@SessionAttributes({"an_name", "an_addr", "an_flag"})
@Controller
public class SessionController {
	
	////////////////////// @SessionAttributes를 사용한 Session 처리 /////////////////////////
	@RequestMapping(value="/session/use_session_att.do", method=GET)
	public String anSessionForm() {
		return "session/an_session_form";
	}
	
	@RequestMapping(value="/session/an_session_param.do", method=POST)
	public String anSessionParam(SessionVO s_vo, Model m) throws UnsupportedEncodingException {

		// 세션에서 사용할 값을 Model객체에 설정한다.
		// 단, 이름은 위에서 정의한 이름과 같아야 세션으로 값이 할당된다.
		// 저장된 값은 requestScope과 sessionScope에 동일하게 할당된다.
		m.addAttribute("an_name", s_vo.getName());
		m.addAttribute("an_addr", s_vo.getAddr());
		
		String url = "session/use_session_att"; // ViewResolver를 통해서 이동
		m.addAttribute("an_flag", "forward로 이동");
		
		return url;
	}
	
	@RequestMapping(value="/session/an_remove_session.do", method=GET)
	public String anRemoveSession(SessionStatus ss) {
		// 1. SessionStatus객체를 매개변수로 선언하고

		// 2. setComplate()를 호출하여 삭제한다.
		ss.setComplete();
		System.out.println("------세션 삭제!------");
		
		return "session/an_session_form";
	}

	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/session/remove_session.do", method=GET)
	public String removeSession(HttpSession session) {
		
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");
		session.invalidate();
		
		return "session/session_form";
	}

	// 요청을 특정 이름으로 묶어서 처리하려면 value에 "/묶을이름/요청.do"의 
	// 형식으로 사용한다.
	@RequestMapping(value="/session/use_session.do", method=GET)
	// 세션 값을 Controller에서 받기, HttpSession을 매개변수로 받아서 처리한다
	public String sessionForm(HttpSession session) {
		String name=(String)session.getAttribute("ses_name");
		String addr=(String)session.getAttribute("ses_addr");
		
		System.out.println("----Controller에서 받은 Session 값 : "+name+" "+addr);
		
		return "session/session_form";
	}
	
	@RequestMapping(value="/session/session_param.do", method=POST)
	public String sessionParam(SessionVO s_vo, HttpSession session) throws UnsupportedEncodingException {
		
		// 입력되는 매개변수를 Session에 할당
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());
		
		String url = "session/use_session"; // ViewResolver를 통해서 이동
		session.setAttribute("flag", "forward로 이동");
		if(new Random().nextBoolean()) {
			// View Resolver를 통하지 않고 이동
			url = "redirect:use_session.jsp";
			session.setAttribute("flag", "redirect로 이동");
		}
		
		return url;
	}
}
