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
	
	////////////////////// @SessionAttributes�� ����� Session ó�� /////////////////////////
	@RequestMapping(value="/session/use_session_att.do", method=GET)
	public String anSessionForm() {
		return "session/an_session_form";
	}
	
	@RequestMapping(value="/session/an_session_param.do", method=POST)
	public String anSessionParam(SessionVO s_vo, Model m) throws UnsupportedEncodingException {

		// ���ǿ��� ����� ���� Model��ü�� �����Ѵ�.
		// ��, �̸��� ������ ������ �̸��� ���ƾ� �������� ���� �Ҵ�ȴ�.
		// ����� ���� requestScope�� sessionScope�� �����ϰ� �Ҵ�ȴ�.
		m.addAttribute("an_name", s_vo.getName());
		m.addAttribute("an_addr", s_vo.getAddr());
		
		String url = "session/use_session_att"; // ViewResolver�� ���ؼ� �̵�
		m.addAttribute("an_flag", "forward�� �̵�");
		
		return url;
	}
	
	@RequestMapping(value="/session/an_remove_session.do", method=GET)
	public String anRemoveSession(SessionStatus ss) {
		// 1. SessionStatus��ü�� �Ű������� �����ϰ�

		// 2. setComplate()�� ȣ���Ͽ� �����Ѵ�.
		ss.setComplete();
		System.out.println("------���� ����!------");
		
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

	// ��û�� Ư�� �̸����� ��� ó���Ϸ��� value�� "/�����̸�/��û.do"�� 
	// �������� ����Ѵ�.
	@RequestMapping(value="/session/use_session.do", method=GET)
	// ���� ���� Controller���� �ޱ�, HttpSession�� �Ű������� �޾Ƽ� ó���Ѵ�
	public String sessionForm(HttpSession session) {
		String name=(String)session.getAttribute("ses_name");
		String addr=(String)session.getAttribute("ses_addr");
		
		System.out.println("----Controller���� ���� Session �� : "+name+" "+addr);
		
		return "session/session_form";
	}
	
	@RequestMapping(value="/session/session_param.do", method=POST)
	public String sessionParam(SessionVO s_vo, HttpSession session) throws UnsupportedEncodingException {
		
		// �ԷµǴ� �Ű������� Session�� �Ҵ�
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());
		
		String url = "session/use_session"; // ViewResolver�� ���ؼ� �̵�
		session.setAttribute("flag", "forward�� �̵�");
		if(new Random().nextBoolean()) {
			// View Resolver�� ������ �ʰ� �̵�
			url = "redirect:use_session.jsp";
			session.setAttribute("flag", "redirect�� �̵�");
		}
		
		return url;
	}
}
