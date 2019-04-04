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
		// 1. 환경설정 xml에 스트림을 연결
		Reader reader = Resources.getResourceAsReader("date0403/mybatis_config.xml");
		// 2. MyBatis Framework 생성
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		// 3. MyBatis Framework과 DB연동한 객체를 얻기(Factory객체를 하나로 관리)
		SqlSessionFactory ssf = ssfb.build(reader);
		
		if (reader != null) {
			reader.close();
		}
		
		return ssf;
	}
	
	public void insertCpDept(date0403.vo.Dept d_vo) throws IOException, SQLException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. Handler 사용하여 DB작업 수행
		int cnt = ss.insert("insertCpDept", d_vo);
		System.out.println("추가 작업 "+cnt);
		
		ss.commit();
	}
	
	public void updateCpDept(date0403.vo.Dept d_vo) throws IOException, SQLException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. Handler 사용하여 DB작업 수행
		int cnt = ss.update("updateCpDept", d_vo);
		System.out.println("업데이트 성공:"+cnt);
		
		ss.commit();
	}
	
	public void selectAllDept() throws IOException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler를 사용하여 DB작업을 수행
		List<Dept> list = ss.selectList("kr.co.sist.selectAllDept"); // namespace 생략가능
	
		Dept d = null;
		for(int i=0; i<list.size(); i++) {
			d = list.get(i);
			System.out.println(d.getDeptno()+"/"
					+d.getDeptno()+"/"+d.getDname()+"/"+d.getLoc());
		}
		
		// 6. 사용이 종료된 SqlSession을 닫는다.
		ss.close();
	}
	
	public void deleteCpDept(int deptno) throws SQLException,IOException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. Handler를 사용해서 DB작업을 수행
		int cnt = ss.delete("deleteCpDept", deptno);
		ss.commit();
		
		if (cnt == 1) {
			System.out.println(deptno+"번 부서정보를 삭제했습니다.");
		} else {
			System.out.println("해당 부서는 존재하지 않습니다.");
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
