package kr.co.sist.exam.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.exam.domain.DeptInfo;
import kr.co.sist.exam.domain.Emp;

public class MyBatisDAO {
	
	private static MyBatisDAO mb_dao;
	private SqlSessionFactory ssf;
	
	public static MyBatisDAO getInstance() {
		if(mb_dao == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // 로깅 사용
			mb_dao = new MyBatisDAO();
		}
		return mb_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() { // synchronized로 Thread에 한개만 생성되서 사용된다.
		Reader r = null;
		
		try {
			// 1. 설정용 XML파일 연결 스트림 생성
			r = Resources.getResourceAsReader("kr/co/sist/exam/dao/mybatis_config.xml");

			// 2. SqlSessionFactoryBuilder 생성 
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
			// 3. 연결스트림을 이용, DB와 연동 된 SqlSessionFactory 객체를 받는다.
			ssf = ssfb.build(r);
			
			if (r != null) { r.close(); } // SqlSessionFactory와 연결 시킨 스트림은 끊는다.
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ssf;
	}
	
	public List<Integer> multiRow() {
		List<Integer> list = null;

		SqlSession ss = getInstance().getSessionFactory().openSession();
		list = ss.selectList("multiRow");
		ss.close();
		
		return list;
	}
	
	public String selectSingleColumn(int deptno) {
		String dname = "";
		
		// MyBatis Handler를 사용하여 Mapper(xml)에 있는 ID를 찾고 Parsing 하여
		// 조회된 결과를 얻는다.
		MyBatisDAO.mb_dao = MyBatisDAO.getInstance();
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		dname = ss.selectOne("singleColumn", deptno);
		ss.close();
		
		return dname;
	}
	
	public DeptInfo selectMultiColumn() {
		DeptInfo di = null;
		
		MyBatisDAO.mb_dao = MyBatisDAO.getInstance();
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		di = ss.selectOne("multiColumn");
		ss.close();
		
		return di;
	}
	
	public List<Emp> multiColumnRow(int deptno) {
		List<Emp> list = null;
		
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. mapper에서 쿼리가 존재하는 id 찾아 실행
		list = ss.selectList("multiColumnRow", deptno);
		ss.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(MyBatisDAO.getInstance().selectMultiColumn());
	}
}
