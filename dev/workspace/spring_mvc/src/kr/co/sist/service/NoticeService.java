package kr.co.sist.service;

import java.util.List;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.NoticeDomain;

public class NoticeService {
	
	public List<NoticeDomain> searchMainNotice() {
		
		List<NoticeDomain> list = null;
		
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		
		// 공지사항은 15자까지만 보여준다.
		list = mb_dao.selectMainNotice();
		for(NoticeDomain temp : list) {
			if (temp.getSubject().length() > 15) {
				temp.setSubject(temp.getSubject().substring(0, 14)+"...");
			}
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new NoticeService().searchMainNotice());
	}
}

