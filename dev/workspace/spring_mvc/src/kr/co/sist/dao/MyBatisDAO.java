package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.domain.NoticeDomain;

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
			r = Resources.getResourceAsReader("kr/co/sist/dao/mybatis_config.xml");

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
	
	public List<NoticeDomain> selectMainNotice() {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		List<NoticeDomain> list = ss.selectList("notice");
		ss.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(MyBatisDAO.getInstance().selectMainNotice());
	}
}
