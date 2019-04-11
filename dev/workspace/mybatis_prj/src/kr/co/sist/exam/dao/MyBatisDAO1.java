

package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicEmp;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.CursorVO;
import kr.co.sist.exam.vo.DeptNo;
import kr.co.sist.exam.vo.DiaryListParam;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TableName;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TransactionVO;

public class MyBatisDAO1 {
	
	public int insertTransaction(TransactionVO tvo) {
		int cnt = 0;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.insert("tr1",tvo);
		cnt += ss.insert("tr2",tvo);
		
		if (cnt == 2) {
			ss.commit();
		}
		// 둘 중에 하나 실패하면 rollback 됨
		ss.close();
		
		return cnt;
	}
	
	
	public void selectProc(CursorVO cv) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("selectProcedure",cv);
		ss.close();
	}
	
	public TestProcVO insertProc(TestProcVO tpvo) {
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		System.out.println(tpvo.getMsg());
		ss.selectOne("insertProcedure",tpvo);
		System.out.println(tpvo.getMsg());
		ss.close();
		
		return tpvo;
	}
	
	public List<Car> dynamicForEach(CarVO cv) {
		List<Car> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicForEach", cv);
		
		return list;
	}
	
	public List<DynamicIf> dynamicChoose(DeptNo deptno) {
		List<DynamicIf> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicChoose", deptno);
		
		return list;
	}
	
	public List<DynamicIf> dynamicIf(DeptNo deptno) {
		List<DynamicIf> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dynamicIf", deptno);
		
		return list;
	}
	
	public List<DynamicEmp> dynamicTable(TableName tname) {
		List<DynamicEmp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dynamicTable",tname);
		
		return list;
	}
	
	public List<Car> joinSubquery() {
		List<Car> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("joinSubquery");
		ss.close();
		
		return list;
	}
	
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
		
		TransactionVO tvo = new TransactionVO("있다는", "김정윤");
		System.out.println(md.insertTransaction(tvo));
	}
}
