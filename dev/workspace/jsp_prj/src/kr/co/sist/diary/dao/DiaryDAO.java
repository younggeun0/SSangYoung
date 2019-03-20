package kr.co.sist.diary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.DiaryDetailVO;
import kr.co.sist.vo.DiaryListVO;
import kr.co.sist.vo.DiaryRemoveVO;
import kr.co.sist.vo.DiaryUpdateVO;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.MonthVO;
import kr.co.sist.vo.SearchDataVO;

public class DiaryDAO {

	private static DiaryDAO d_dao;
	
	private DiaryDAO() {
	}
	
	public static DiaryDAO getInstance() {
		if (d_dao == null) {
			d_dao = new DiaryDAO();
		}
		
		return d_dao;
	}
	
	/**
	 * 년, 월을 입력받아 해당 월의 모든 일자의 글 번호와 제목을 가변배열에 저장하여
	 * 반환하는 일
	 * @param year 년
	 * @param month 월
	 * @return 가변배열
	 * @throws SQLException
	 */
	public MonthVO[][] selectMonthEvent(String year, String month) throws SQLException {
		MonthVO[][] mvo = new MonthVO[31][];
		
		return mvo;
	}
	
	/**
	 * 이벤트 추가
	 * @param dvo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO dvo) throws SQLException{
		
	}
	
	/**
	 * 글 번호를 입력받아 해당 이벤트의 상세 정보 조회
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public DiaryDetailVO selectDetailEvent(int num) throws SQLException {
		DiaryDetailVO ddvo = null;
		
		
		return ddvo;
	}
	
	/**
	 * 글번호, 내용, 비밀번호를 입력받아 비밀번호가 일치하면 해당 글번호의
	 * 이벤트 내용을 변경하는 일
	 * @param duvo
	 * @return
	 * @throws SQLException
	 */
	public int updateEvent(DiaryUpdateVO duvo) throws SQLException {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * 글번호, 비밀번호를 입력받아 해당 글 을 삭제하는 일
	 * @param drvo
	 * @return
	 * @throws SQLException
	 */
	public int deleteEvent(DiaryRemoveVO drvo) throws SQLException {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * 게시판의 리스트형식으로 조회하는 일
	 * @param sdvo
	 * @return
	 * @throws SQLException
	 */
	public List<DiaryListVO> selectList(SearchDataVO sdvo) throws SQLException{
		List<DiaryListVO> list = new ArrayList<DiaryListVO>();
		
		return list;
	}
}
