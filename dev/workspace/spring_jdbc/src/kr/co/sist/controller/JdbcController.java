package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oreilly.servlet.MultipartRequest;

import kr.co.sist.domain.DetailMember;
import kr.co.sist.domain.Member;
import kr.co.sist.service.JdbcService;
import kr.co.sist.vo.MemberUpdateVO;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class JdbcController {

	@Autowired
	private JdbcService js;
	
	@RequestMapping(value="/index.do", method= { GET,POST })
	public String main() {
		return "index";
	}
	
	@RequestMapping(value="/add_form.do", method=GET)
	public String memberUploadForm() {
		return "member/add_form";
	}
	
	@RequestMapping(value="/add_member_process.do", method=POST)
	public String uploadProcess(HttpServletRequest request, Model model) {
		String moveURL = "redirect:err/err.html";

		try {
			if(js.fileUploadProcess(request,model)) {
				moveURL = "member/upload_success";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return moveURL;
	}
	
	@RequestMapping(value="/search_member.do", method=GET)
	public String searchAllMember(Model model) {
		
		List<Member> list = js.searchAllMember();
		model.addAttribute("memberList", list);
		
		return "member/member_list";
	}
	
	@RequestMapping(value="/detail_member.do", method=GET)
	public String detailMember(@RequestParam(defaultValue="0") int num, Model model) {
		
		DetailMember dm = js.searchOneMember(num);
		model.addAttribute("detailMember", dm);
		
		return "member/detail_member";
	}
	
	@RequestMapping(value="/update_member.do", method=POST)
	public String modifyMember(MemberUpdateVO muvo, Model model) {
		
		String resultMsg = "회원정보를 수정할 수 없습니다";
		boolean resultFlag = false;
		
		if(js.updateMember(muvo)) {
			resultMsg = muvo.getName()+"님 정보를 변경하였습니다";
			resultFlag = true;
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultFlag", resultFlag);
		
		return "member/update_result";
	}
	
	@RequestMapping(value="/delete_member.do", method=POST)
	public String removeMember(int num, Model model) {

		String resultMsg = "회원정보를 삭제할 수 없습니다";
		boolean resultFlag = false;
		
		if(js.deleteMember(num)) {
			resultMsg = "회원정보가 삭제되었습니다.";
			resultFlag = true;
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultFlag", resultFlag);
		
		return "member/remove_result";
	}
}
