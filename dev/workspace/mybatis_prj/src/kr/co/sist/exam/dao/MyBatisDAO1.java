

package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.DiaryListParam;
import kr.co.sist.exam.vo.EmpVO;

public class MyBatisDAO1 {
	
	public List<EmpJoin> join(int mgr) {
		List<EmpJoin> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("join", mgr);
		ss.close();
		
		return list;
	}
	
	public List<Union> union() {
		List<Union> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("union");
		ss.close();
		
		return list;
	}
	
	public int diaryTotalCount() {
		int cnt = 0;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.selectOne("diaryCnt");
		ss.close();
		
		return cnt;
	}
	
	public List<DiaryList> subquery(DiaryListParam dlpvo) {
		List<DiaryList> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("subquery", dlpvo);
		
		return list;
	}

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
		System.out.println(md.join(7698));
	}
}
