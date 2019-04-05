package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO;
import kr.co.sist.exam.domain.DeptInfo;
import kr.co.sist.exam.domain.Emp;

public class MyBatisService {
	public String deptName(int deptno) {
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		String dname ="";
		dname = mb_dao.selectSingleColumn(deptno)+"ºÎ¼­";
		return dname;
	}
	
	public DeptInfo deptInfo() {
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		DeptInfo di = mb_dao.selectMultiColumn();
		
		return di;
	}
	
	public List<Integer> multiRow() {
		List<Integer> list = null;
		
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		list = mb_dao.multiRow();
		
		return list;
	}
	
	public List<Emp> multiColumnRow(int deptno) {
		List<Emp> list = null;
		
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		list = mb_dao.multiColumnRow(deptno);
		
		return list;
	}
}
