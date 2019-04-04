package date0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import date0403.domain.Dept;

public class UseMyBatis {
	
	public UseMyBatis() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	public SqlSessionFactory getSessionFactory() throws IOException {
		// 1. ȯ�漳�� xml�� ��Ʈ���� ����
		Reader reader = Resources.getResourceAsReader("date0403/mybatis_config.xml");
		// 2. MyBatis Framework ����
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		// 3. MyBatis Framework�� DB������ ��ü�� ���(Factory��ü�� �ϳ��� ����)
		SqlSessionFactory ssf = ssfb.build(reader);
		
		if (reader != null) {
			reader.close();
		}
		
		return ssf;
	}
	
	public void insertCpDept(date0403.vo.Dept d_vo) throws IOException, SQLException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. Handler ����Ͽ� DB�۾� ����
		int cnt = ss.insert("insertCpDept", d_vo);
		System.out.println("�߰� �۾� "+cnt);
		
		ss.commit();
	}
	
	public void updateCpDept(date0403.vo.Dept d_vo) throws IOException, SQLException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. Handler ����Ͽ� DB�۾� ����
		int cnt = ss.update("updateCpDept", d_vo);
		System.out.println("������Ʈ ����:"+cnt);
		
		ss.commit();
	}
	
	public void selectAllDept() throws IOException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler�� ����Ͽ� DB�۾��� ����
		List<Dept> list = ss.selectList("kr.co.sist.selectAllDept"); // namespace ��������
	
		Dept d = null;
		for(int i=0; i<list.size(); i++) {
			d = list.get(i);
			System.out.println(d.getDeptno()+"/"
					+d.getDeptno()+"/"+d.getDname()+"/"+d.getLoc());
		}
		
		// 6. ����� ����� SqlSession�� �ݴ´�.
		ss.close();
	}
	
	public void deleteCpDept(int deptno) throws SQLException,IOException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. Handler�� ����ؼ� DB�۾��� ����
		int cnt = ss.delete("deleteCpDept", deptno);
		ss.commit();
		
		if (cnt == 1) {
			System.out.println(deptno+"�� �μ������� �����߽��ϴ�.");
		} else {
			System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		try {
			umb.updateCpDept(new date0403.vo.Dept(23, "youngss", "seoul"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
