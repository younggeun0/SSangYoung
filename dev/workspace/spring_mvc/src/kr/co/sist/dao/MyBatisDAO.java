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
			org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // �α� ���
			mb_dao = new MyBatisDAO();
		}
		return mb_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() { // synchronized�� Thread�� �Ѱ��� �����Ǽ� ���ȴ�.
		Reader r = null;
		
		try {
			// 1. ������ XML���� ���� ��Ʈ�� ����
			r = Resources.getResourceAsReader("kr/co/sist/dao/mybatis_config.xml");

			// 2. SqlSessionFactoryBuilder ���� 
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		
			// 3. ���ὺƮ���� �̿�, DB�� ���� �� SqlSessionFactory ��ü�� �޴´�.
			ssf = ssfb.build(r);
			
			if (r != null) { r.close(); } // SqlSessionFactory�� ���� ��Ų ��Ʈ���� ���´�.
		
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
