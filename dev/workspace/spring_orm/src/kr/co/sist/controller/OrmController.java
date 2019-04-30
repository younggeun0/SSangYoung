package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.Lunch;
import kr.co.sist.service.OrmService;

@Controller
public class OrmController {
	
	@Autowired(required = false)
	private OrmService os;

	@RequestMapping(value="/index.do", method=GET)
	public String test(Model model) {
		
		String url = "lunch/lunch_list";
		List<Lunch> list = os.searchAllList();
		model.addAttribute("lunchList", list);
		
		if (list == null) {
			url = "redirect:err/lunch_err.jsp";
		}
		
		return url;
	}
	
	@ResponseBody
	@RequestMapping(value="/lunch_detail.do", method=GET, produces="text/plain;charset=UTF-8")
	public String searchDetail(String lunch_code) {
		JSONObject json = os.searchDetailLunch(lunch_code);
		return json.toJSONString();
	}
}
