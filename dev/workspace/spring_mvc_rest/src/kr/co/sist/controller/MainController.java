package kr.co.sist.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	public String indexMove() {
		return "redirect:index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/method/get")
	public String getProcess(String name) {
		System.out.println("====== GET방식의 요청, 전달받은 param"+name);
		
		return "get";
	}
	
	@PostMapping("/method/post")
	public String postProcess() {
		return "post";
	}
	
	@ResponseBody
	@PutMapping(value="/method/put/{id}", produces="application/json;charset=UTF-8")
	public String putProcess(@RequestBody String json) {
		
		JSONParser jp = new JSONParser();
		JSONObject json_obj = null;
		
		try {
			json_obj = (JSONObject)jp.parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return json_obj.toJSONString();
	}
	
	
}
