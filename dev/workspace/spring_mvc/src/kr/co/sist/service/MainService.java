package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.NoticeDomain;

@Component
public class MainService {

	@Autowired
	private MyBatisDAO mb_dao;
	
	public List<NoticeDomain> noticeList() {
		List<NoticeDomain> list = mb_dao.selectMainNotice();
		
		return list;
	}
}
