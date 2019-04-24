package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.JdbcDAO;

@Component
public class JdbcService {

	@Autowired(required=false)
	private JdbcDAO jdao;
	
	public void daoPrint() { 
		System.out.println("Äõ¸® ½ÇÇà °´Ã¼ : "+jdao.getJt());
	}
}
