package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ChainController {

	@RequestMapping(value="/chain/chain_a.do",method=GET)
	public String chainA(Model model) {
		
		String[] lunch = { "¹ö°ÅÅ·", "KFC", "¸Æ³¯", "¸¾½ºÅÍÄ¡", "·Ôµ¥¸®¾Æ" };
		model.addAttribute("lunch", lunch);
		
		return "forward:/chain/chain_b.do";
	}
	
	@RequestMapping(value="/chain/chain_b.do",method=GET)
	public String chainB() { 
		return "chain/chain_b_result";
	}
}
