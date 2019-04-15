package kr.co.sist.controller.webparam;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.domain.NoticeDomain;
import kr.co.sist.service.NoticeService;

import static org.springframework.web.bind.annotation.RequestMethod.GET; 
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List; 

@Controller
public class DataController {
	
	@RequestMapping(value="/use_redirect.do", method=GET)
	public String moveRedirect() {
		
		// redirect�� return �� �տ� �پ������� WEB-INF/views ������ �̵��ϴ� ���� �ƴ�
		// WebContent �� ������ �̵��ϰ� �ȴ�.
		return "redirect:date0415/use_redirect.jsp";
	}

	@RequestMapping(value="/view_request.do", method= { GET, POST })
	public String useRequest(HttpServletRequest request) {

		// ���� ����
		NoticeService ns = new NoticeService();
		List<NoticeDomain> noticeList = ns.searchMainNotice();
		
		// ���������� ��ȸ�Ͽ� JSP�� �����Ѵ�.(Scope ��ü ���)
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletRequest ���");
		
		return "data/use_data";
	}
	
	@RequestMapping(value="/view_model.do", method= { GET, POST })
	public String useModel(Model m) {
		
		// ���� ����
		NoticeService ns = new NoticeService();
		List<NoticeDomain> noticeList = ns.searchMainNotice();
		
		// ���������� ��ȸ�Ͽ� JSP�� �����Ѵ�.(Scope ��ü ���)
		m.addAttribute("req_data", noticeList);
		m.addAttribute("msg", "Model ���");
		
		return "data/use_data";
	}
	
	@RequestMapping(value="/view_modelandview.do", method= { GET, POST })
	public ModelAndView useModelAndView() {
		
		// ���� ����
		NoticeService ns = new NoticeService();
		List<NoticeDomain> noticeList = ns.searchMainNotice();
		
		// ���������� ��ȸ�Ͽ� JSP�� �����Ѵ�.(Scope ��ü ���)
		// 1. ��ü ����
		ModelAndView mav = new ModelAndView();
		
		// 2. view�� JSP���� ����
		mav.setViewName("data/use_data");
		
		// 3. �����͸� ����
		mav.addObject("req_data", noticeList);
		mav.addObject("msg", "ModelAndView ���");
		
		return mav; // ModelAndView ��ü ��ȯ!
	}
}
