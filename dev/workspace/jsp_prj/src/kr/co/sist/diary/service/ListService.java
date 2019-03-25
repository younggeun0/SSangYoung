package kr.co.sist.diary.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.diary.dao.DiaryDAO;
import kr.co.sist.vo.DiaryListVO;
import kr.co.sist.vo.ListRangeVO;
import kr.co.sist.vo.SearchDataVO;

/**
 * 게시판 리스트에 관한 업무 처리 클래스
 * @author owner
 */
public class ListService {
	
	private static ListService ls;
	
	private ListService() {}
	
	public static ListService getInstance() {
		if (ls == null) {
			ls = new ListService();
		}
		
		return ls;
	}
	
	public int totalCount(SearchDataVO sdvo) {
		int totalCnt = 0;
		DiaryDAO d_dao = DiaryDAO.getInstance();
		
		// 1. 전체 페이지 수를 얻기
		try {
			totalCnt = d_dao.selectEvtCnt(sdvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCnt;
	}
	
	public int pageScale() {
		int pageScale = 10;
		
		return pageScale;
	}
	
	public int totalPage(int totalCnt) {
		int totalPage = totalCnt/pageScale();
		
		if (totalCnt%pageScale() != 0) {
			totalPage++;
		}
		
		return totalPage;
	}
	
	public int startNum(String currentPage) {
		int startNum = 1;
		
		if (currentPage != null) {
			int tempPage = Integer.parseInt(currentPage);
			startNum = tempPage*pageScale() - pageScale() + 1;
		}
		
		return startNum;
	}
	
	public int endNum(int startNum) {
		int endNum = startNum + pageScale() - 1; 
		return endNum;
	}
	
	public List<DiaryListVO> searchList(SearchDataVO sdvo, ListRangeVO lrvo) {
		List<DiaryListVO> list = new ArrayList<DiaryListVO>();

		DiaryDAO d_dao = DiaryDAO.getInstance();
		
		try {
			list = d_dao.selectList(sdvo, lrvo);
			
			DiaryListVO dlvo = null;
			String subject = "";
			// 글의 제목은 24자 까지만 보여준다.
			for(int i=0; i<list.size(); i++) {
				dlvo = list.get(i);
				subject= dlvo.getSubject();
				
				if( subject.length() > 25 ) {
					subject = subject.substring(0, 24)+"...";
					dlvo.setSubject(subject);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String indexList(String url, SearchDataVO sdvo, int totalPage) {
		StringBuilder indexList = new StringBuilder();
		
		for(int i=1; i<= totalPage; i++) {
			indexList.append("[ ").append("<a href='")
			.append(url).append("?current_page=")
			.append(i);
			if (sdvo != null) {
				indexList.append("&fieldName=").append(sdvo.getFieldName())
				.append("&keyword=").append(sdvo.getKeyword());
			}
			indexList.append("'>").append(i).append("</a> ]");
		}
		
		return indexList.toString();
	}
}
