package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.OrmDAO;

@Component
public class OrmService {
	
	@Autowired(required=false)
	private OrmDAO odao;
	
	public void test() {
		System.out.println("-------"+odao);
	}
}
