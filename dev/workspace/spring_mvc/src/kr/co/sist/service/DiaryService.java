package kr.co.sist.service;

import java.util.List;

import org.json.simple.JSONObject;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.DiaryDetailDomain;
import kr.co.sist.domain.DiaryDomain;
import kr.co.sist.domain.DiaryReplyDomain;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

/**
 * 시작번호와 끝번호 사이의 게시물을 조회하기 위한 모든 작업을 정의
 * 
 * @author owner
 */
public class DiaryService {

	private MyBatisDAO mb_dao;

	public DiaryService() {
		mb_dao = MyBatisDAO.getInstance();
	}
	
	public DiaryDetailDomain serachBbs(int num) {
		DiaryDetailDomain ddd = mb_dao.selectDiaryDetail(num);
		return ddd;
	}

	/**
	 * 총 게시물의 수 얻기
	 * 
	 * @return
	 */
	public int totalCnt() {
		int cnt = 0;
		cnt = mb_dao.selectTotalCnt();
		return cnt;
	}

	/**
	 * 한 화면에 보여줄 게시물의 수
	 * @return
	 */
	public int pageScale() {
		int pageScale = 10;

		return pageScale;
	}

	/**
	 * 모든 게시물을 보여주기 위한 페이지 수
	 * @param totalCnt
	 * @return
	 */
	public int totalPage(int totalCnt) {
		int totalPage = totalCnt / pageScale();

		if (totalCnt % pageScale() != 0) {
			totalPage++;
		}

		return totalPage;
	}

	/**
	 * 선택한 인덱스 리스트에서 조회할 시작 번호
	 * @param currentPage
	 * @return
	 */
	public int startNum(int currentPage) {
		int startNum = 1;
		startNum = currentPage * pageScale() - pageScale() + 1;
		return startNum;
	}

	/**
	 * 선택한 인덱스 리스트에서 조회할 끝 번호
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum = startNum + pageScale() - 1;
		return endNum;
	}
	
	public List<DiaryDomain> searchDiaryList(DiaryVO dv) {
		List<DiaryDomain> list = null;
		list = mb_dao.selectList(dv);
		
		DiaryDomain temp = null;
		String subject = "";
		// 글의 제목은 24자 까지만 보여준다.
		for(int i=0; i<list.size(); i++) {
			temp = list.get(i);
			subject = temp.getSubject();
			
			if( subject.length() > 25 ) {
				subject = subject.substring(0, 24)+"...";
				temp.setSubject(subject);
			}
		}
		
		return list;
	}
	
	public List<DiaryReplyDomain> searchReplyList(int num) {
		List<DiaryReplyDomain> list = null;
		list = mb_dao.selectReply(num);
		return list;
	}
	
	public JSONObject addReply(ReplyVO r_vo) {
		JSONObject json = new JSONObject();
		int cnt = mb_dao.insertReply(r_vo);
		json.put("result", cnt == 1);
		
		return json;
	}

	/**
	 * 인덱스 리스트 [<<]...[1][2][3]...[>>]
	 * @param current_page
	 * @param total_page
	 * @param list_url
	 * @return
	 */
	// 현재 게시판의 페이지 인덱스 설정
	public String indexList(int current_page, int total_page, String list_url) {
		int pagenumber; // 화면에 보여질 페이지 인덱스 수
		int startpage; // 화면에 보여질 시작페이지 번호
		int endpage; // 화면에 보여질 마지막페이지 번호
		int curpage; // 이동하고자 하는 페이지 번호

		String strList = ""; // 리턴될 페이지 인덱스 리스트

		pagenumber = 10; // 한 화면의 페이지 인덱스 수

		// 시작 페이지번호 구하기
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

		// 마지막 페이지번호 구하기
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

		// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우

		// 총 페이지 수가 마지막페이지 번호가 됨

		if (total_page <= endpage) {
			endpage = total_page;
		} // end if

		// 첫번째 페이지 인덱스 화면이 아닌경우
		if (current_page > pagenumber) {
			curpage = startpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
			strList = strList + "[ <a href=" + list_url + "?currPage=" + curpage + ">&lt;&lt;</a> ]";
		} else {
			strList = strList + "[<<]";
		}

		strList = strList + " ... ";

		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		curpage = startpage;

		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "[ " + current_page + " ]";
			} else {
				strList = strList + "[ <a href=" + list_url + "?currPage=" + curpage + ">" + curpage + " </a> ]";
			} // end else

			curpage++;
		} // end while

		strList = strList + " ... ";

		// 뒤에 페이지가 더 있는경우
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "[ <a href=" + list_url + "?currPage=" + curpage + ">&gt;&gt;</a> ]";
		} else {
			strList = strList + "[>>]";
		} // end else

		return strList;
	}// indexList
}
