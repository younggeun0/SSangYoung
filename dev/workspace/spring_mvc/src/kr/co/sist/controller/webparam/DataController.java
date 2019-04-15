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
		
		// redirect가 return 값 앞에 붙어있으면 WEB-INF/views 폴더로 이동하는 것이 아닌
		// WebContent 내 폴더로 이동하게 된다.
		return "redirect:date0415/use_redirect.jsp";
	}

	@RequestMapping(value="/view_request.do", method= { GET, POST })
	public String useRequest(HttpServletRequest request) {

		// 업무 수행
		NoticeService ns = new NoticeService();
		List<NoticeDomain> noticeList = ns.searchMainNotice();
		
		// 공지사항을 조회하여 JSP로 전달한다.(Scope 객체 사용)
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletRequest 사용");
		
		return "data/use_data";
	}
	
	@RequestMapping(value="/view_model.do", method= { GET, POST })
	public String useModel(Model m) {
		
		// 업무 수행
		NoticeService ns = new NoticeService();
		List<NoticeDomain> noticeList = ns.searchMainNotice();
		
		// 공지사항을 조회하여 JSP로 전달한다.(Scope 객체 사용)
		m.addAttribute("req_data", noticeList);
		m.addAttribute("msg", "Model 사용");
		
		return "data/use_data";
	}
	
	@RequestMapping(value="/view_modelandview.do", method= { GET, POST })
	public ModelAndView useModelAndView() {
		
		// 업무 수행
		NoticeService ns = new NoticeService();
		List<NoticeDomain> noticeList = ns.searchMainNotice();
		
		// 공지사항을 조회하여 JSP로 전달한다.(Scope 객체 사용)
		// 1. 객체 생성
		ModelAndView mav = new ModelAndView();
		
		// 2. view할 JSP명을 설정
		mav.setViewName("data/use_data");
		
		// 3. 데이터를 설정
		mav.addObject("req_data", noticeList);
		mav.addObject("msg", "ModelAndView 사용");
		
		return mav; // ModelAndView 객체 반환!
	}
}
