package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncludeController {

	@RequestMapping(value="/include/include.do", method=RequestMethod.GET)
	public String include() {
		return "include/use_include";
	}

	
}
