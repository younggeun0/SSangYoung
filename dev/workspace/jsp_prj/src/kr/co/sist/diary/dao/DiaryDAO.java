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
			// 1. JNDI ��� ��ü ����
			Context ctx = new InitialContext();
			
			// 2. DBCP�� ����� DataSource ���
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			
			// 3. Connection ���
			con = ds.getConnection();
		
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	/**
	 * ��, ���� �Է¹޾� �ش� ���� ��� ������ �� ��ȣ�� ������ �����迭�� �����Ͽ�
	 * ��ȯ�ϴ� ��
	 * @param year ��
	 * @param month ��
	 * @return �����迭
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

			for(int i=1; i<32; i++) { // �ش� ����� 1�Ϻ��� 31�ϱ��� ���� ����
				pstmt.setString(3, String.valueOf(i));
				rs = pstmt.executeQuery();
				
				int idx = 0;
				while(rs.next()) { // ���� ����� �����Ѵٸ�
					// �ش� ������ ���� �����ϹǷ� ���� ���� �����Ѵ�.
					list.add(new MonthVO(rs.getInt("num"), rs.getString("subject")));
				}
				rs.close();
				if (list.size() != 0) {
					// ���� ������ �迭 ����
					MonthVO[] mvoArr = new MonthVO[list.size()];
					// ����Ʈ�� �����ϴ� ���� ������ �迭�� ����
					list.toArray(mvoArr);
					// ������ �迭�� ���� �����迭�� i�࿡ �߰�
					mvo[i-1] = mvoArr;
				}
				list.clear(); // ����Ʈ �ʱ�ȭ
			}
		} finally {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return mvo;
	}
	
	/**
	 * �̺�Ʈ �߰�
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
	 * �� ��ȣ�� �Է¹޾� �ش� �̺�Ʈ�� �� ���� ��ȸ
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public DiaryDetailVO selectDetailEvent(int num) throws SQLException {
		DiaryDetailVO ddvo = null;
		
		
		return ddvo;
	}
	
	/**
	 * �۹�ȣ, ����, ��й�ȣ�� �Է¹޾� ��й�ȣ�� ��ġ�ϸ� �ش� �۹�ȣ��
	 * �̺�Ʈ ������ �����ϴ� ��
	 * @param duvo
	 * @return
	 * @throws SQLException
	 */
	public int updateEvent(DiaryUpdateVO duvo) throws SQLException {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * �۹�ȣ, ��й�ȣ�� �Է¹޾� �ش� �� �� �����ϴ� ��
	 * @param drvo
	 * @return
	 * @throws SQLException
	 */
	public int deleteEvent(DiaryRemoveVO drvo) throws SQLException {
		int cnt = 0;
		
		return cnt;
	}
	
	/**
	 * �Խ����� ����Ʈ�������� ��ȸ�ϴ� ��
	 * @param sdvo
	 * @return
	 * @throws SQLException
	 */
	public List<DiaryListVO> selectList(SearchDataVO sdvo) throws SQLException{
		List<DiaryListVO> list = new ArrayList<DiaryListVO>();
		
		return list;
	}
}
