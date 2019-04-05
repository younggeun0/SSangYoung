package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO;
import kr.co.sist.exam.dao.MyBatisDAO1;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.EmpVO;

public class MyBatisService1 {
	public List<Emp> multiParam(EmpVO ev) {
		List<Emp> list = null;
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.multiParam(ev);
		
		return list;
	}
	
	public List<Emp> lessThan(int sal) {
		List<Emp> list = null;
		
		if (sal < 0) { // 음수는 절대값 처리
			sal = Math.abs(sal);
			// 또는 sal = -sal;
		}
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.lessThan(sal);
		
		return list;
	}
	
	public List<Emp> greaterThan(int sal) {
		List<Emp> list = null;
		
		if (sal < 0) { // 음수는 절대값 처리
			sal = Math.abs(sal);
			// 또는 sal = -sal;
		}
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.greaterThan(sal);
		
		return list;
	}
	
	public List<Zipcode> like(String dong) {
		List<Zipcode> list = null;
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.like(dong);
		
		return list;
	}
}
