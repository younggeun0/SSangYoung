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
		
		int totalCnt = ds.totalCnt(); // �� �Խù��� �� 
		int pageScale = ds.pageScale(); // �� ȭ�鿡 ������ �Խù��� ��
		int totalPage = ds.totalPage(totalCnt); // ��ü �Խù��� �����ֱ� ���� �� ������ ��

		// ���� ȣ�� ��, web parameter�� ���� ���� �� 
		if (dv.getCurrPage() == 0) { 
			dv.setCurrPage(1); // ������������ 1�� ����
		}
		
		int startNum = ds.startNum(dv.getCurrPage()); // ���۹�ȣ
		int endNum = ds.endNum(startNum);
		
		dv.setBegin(startNum);
		dv.setEnd(endNum);
		
		// ����Ʈ ��� ��ȸ
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
		DiaryDetailDomain ddd = ds.serachBbs(num); // ������ ������ ��ȸ
		// ������ ��۵��� ��ȸ
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

