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
			org.apache.ibatis.logging.LogFactory.useLog4JLogging(); // �α� ���
			mb_dao = new MyBatisDAO();
		}
		return mb_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() { // synchronized�� Thread�� �Ѱ��� �����Ǽ� ���ȴ�.
		Reader r = null;
		
		try {
			// 1. ������ XML���� ���� ��Ʈ�� ����
			r = Resources.getResourceAsReader("kr/co/sist/exam/dao/mybatis_config.xml");

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
	
	public List<Integer> multiRow() {
		List<Integer> list = null;

		SqlSession ss = getInstance().getSessionFactory().openSession();
		list = ss.selectList("multiRow");
		ss.close();
		
		return list;
	}
	
	public String selectSingleColumn(int deptno) {
		String dname = "";
		
		// MyBatis Handler�� ����Ͽ� Mapper(xml)�� �ִ� ID�� ã�� Parsing �Ͽ�
		// ��ȸ�� ����� ��´�.
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
		
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. mapper���� ������ �����ϴ� id ã�� ����
		list = ss.selectList("multiColumnRow", deptno);
		ss.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(MyBatisDAO.getInstance().selectMultiColumn());
	}
}
