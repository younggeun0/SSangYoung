package kr.co.sist.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	
	private Connection getConn() throws SQLException {
		Connection con = null;
		
		try {
			// 1. JNDI 사용 객체 생성
			Context ctx = new InitialContext();
			
			// 2. DBCP에 저장된 DataSource 얻기
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			
			// 3. Connection 얻기
			con = ds.getConnection();
		
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return con;
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
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			
			StringBuilder selectMonthData = new StringBuilder();
			
			selectMonthData
			.append(" SELECT num, subject ")
			.append(" FROM diary ")
			.append(" WHERE e_year=? and e_month=? and e_date=? ");
			
			MonthVO temp = null;
			List<MonthVO> list = new ArrayList<MonthVO>();
			
			pstmt = con.prepareStatement(selectMonthData.toString());
			pstmt.setString(1, year);
			pstmt.setString(2, month);

			for(int i=1; i<32; i++) { // 해당 년월의 1일부터 31일까지 쿼리 수행
				pstmt.setString(3, String.valueOf(i));
				rs = pstmt.executeQuery();
				
				int idx = 0;
				while(rs.next()) { // 실행 결과가 존재한다면
					// 해당 일자의 글이 존재하므로 글의 값을 저장한다.
					list.add(new MonthVO(rs.getInt("num"), rs.getString("subject")));
				}
				rs.close();
				if (list.size() != 0) {
					// 글을 저장할 배열 생성
					MonthVO[] mvoArr = new MonthVO[list.size()];
					// 리스트에 존재하는 값을 일차원 배열에 복사
					list.toArray(mvoArr);
					// 일차원 배열의 값을 가변배열의 i행에 추가
					mvo[i-1] = mvoArr;
				}
				list.clear(); // 리스트 초기화
			}
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return mvo;
	}
	
	/**
	 * 이벤트 추가
	 * @param dvo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO dvo) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 2. 3.
			con = getConn();
			
			StringBuilder insertEvent = new StringBuilder();
			
			insertEvent
			.append(" INSERT INTO diary(NUM,WRITER,SUBJECT,CONTENT,E_YEAR,E_MONTH,E_DATE,PASS,IP) ")
			.append(" VALUES (seq_diary.nextval,?,?,?,?,?,?,?,?) ");
			
			pstmt = con.prepareStatement(insertEvent.toString());
			pstmt.setString(1, dvo.getWriter());
			pstmt.setString(2, dvo.getSubject());
			pstmt.setString(3, dvo.getContent());
			pstmt.setString(4, dvo.getE_year());
			pstmt.setString(5, dvo.getE_month());
			pstmt.setString(6, dvo.getE_date());
			pstmt.setString(7, dvo.getPass());
			pstmt.setString(8, dvo.getIp());
			
			pstmt.executeUpdate();
			
		} finally {
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
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
