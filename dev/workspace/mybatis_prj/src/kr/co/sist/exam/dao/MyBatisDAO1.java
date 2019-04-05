

package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.EmpVO;

public class MyBatisDAO1 {

	public List<Emp> multiParam(EmpVO ev) {
		List<Emp> list = null;

		// 4. 핸들러 얻기
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list = ss.selectList("multiparam", ev);
		ss.close();
		
		return list;
	}
	
	public List<Emp> lessThan(int sal) {
		List<Emp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("lessThan",sal);
		ss.close();
		
		return list;
	}

	public List<Emp> greaterThan(int sal) {
		List<Emp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("greaterThan",sal);
		ss.close();
		
		return list;
	}
	
	public List<Zipcode> like(String dong) {
		List<Zipcode> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("like", dong);
		ss.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		
		MyBatisDAO1 md = new  MyBatisDAO1();
		md.lessThan(300);
	}
}
