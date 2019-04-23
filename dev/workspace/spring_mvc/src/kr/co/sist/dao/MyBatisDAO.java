package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.DiaryDetailDomain;
import kr.co.sist.domain.DiaryDomain;
import kr.co.sist.domain.DiaryReplyDomain;
import kr.co.sist.domain.NoticeDomain;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

@Component
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
	
	public DiaryDetailDomain selectDiaryDetail(int num) {
		DiaryDetailDomain ddd = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		ddd = ss.selectOne("diaryDetail",num);
		ss.close();
		
		return ddd;
	}
	
	public List<NoticeDomain> selectMainNotice() {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		List<NoticeDomain> list = ss.selectList("notice");
		ss.close();
		
		return list;
	}
	
	public List<DiaryReplyDomain> selectReply(int num) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		List<DiaryReplyDomain> list = ss.selectList("diaryReply",num);
		ss.close();
		return list;
	}
	
	public List<DiaryDomain> selectList(DiaryVO dv) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		List<DiaryDomain> list = ss.selectList("diaryList",dv);
		ss.close();
		return list;
	}
	
	public int selectTotalCnt() {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		int cnt = ss.selectOne("diaryTotalCnt");
		ss.close();
		return cnt;
	}
	
	public int insertReply(ReplyVO r_vo) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		int cnt = ss.insert("addReply",r_vo);
		if (cnt == 1) {
			ss.commit();
		}
		ss.close();
		
		return cnt;
	}
}
