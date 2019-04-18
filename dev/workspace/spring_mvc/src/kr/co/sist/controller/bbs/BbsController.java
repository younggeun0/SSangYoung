package kr.co.sist.controller.bbs;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.DiaryDetailDomain;
import kr.co.sist.domain.DiaryDomain;
import kr.co.sist.domain.DiaryReplyDomain;
import kr.co.sist.service.DiaryService;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

@Controller
public class BbsController {
	@RequestMapping(value="/diary/list.do", method=GET)
	public String diaryList(DiaryVO dv, Model model) {
		
		DiaryService ds = new DiaryService();
		
		int totalCnt = ds.totalCnt(); // 총 게시물의 수 
		int pageScale = ds.pageScale(); // 한 화면에 보여줄 게시물의 수
		int totalPage = ds.totalPage(totalCnt); // 전체 게시물을 보여주기 위한 총 페이지 수

		// 최초 호출 시, web parameter에 값이 없을 때 
		if (dv.getCurrPage() == 0) { 
			dv.setCurrPage(1); // 시작페이지를 1로 설정
		}
		
		int startNum = ds.startNum(dv.getCurrPage()); // 시작번호
		int endNum = ds.endNum(startNum);
		
		dv.setBegin(startNum);
		dv.setEnd(endNum);
		
		// 리스트 목록 조회
		List<DiaryDomain> diaryList = ds.searchDiaryList(dv);
		String indexList = ds.indexList(dv.getCurrPage(), totalPage, "list.do");
		
		model.addAttribute("diaryList",diaryList);
		model.addAttribute("indexList",indexList);
		
		model.addAttribute("pageScale",pageScale);
		model.addAttribute("currentPage",dv.getCurrPage());
		model.addAttribute("totalCnt",totalCnt);
		
		return "diary/list";
	}
	
	@RequestMapping(value="/diary/bbs_read.do", method=GET)
	public String bbsRead(int num, Model model) {
		
		DiaryService ds = new DiaryService();
		DiaryDetailDomain ddd = ds.serachBbs(num); // 원글의 내용을 조회
		// 원글의 댓글들을 조회
		List<DiaryReplyDomain> replyList = ds.searchReplyList(num);
		
		model.addAttribute("searchData", ddd);
		model.addAttribute("replyList", replyList);
		
		return "diary/bbs_read";
	}
	
	@ResponseBody
	@RequestMapping(value="/diary/add_reply.do", method=GET)
	public String writeReply(ReplyVO r_vo) {
		JSONObject json = null;
		
		DiaryService ds = new DiaryService();
		json = ds.addReply(r_vo);
		
		return json.toJSONString();
	}
}

