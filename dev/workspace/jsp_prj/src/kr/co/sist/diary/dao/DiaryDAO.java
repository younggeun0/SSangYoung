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
	 * ��, ���� �Է¹޾� �ش� ���� ��� ������ �� ��ȣ�� ������ �����迭�� �����Ͽ�
	 * ��ȯ�ϴ� ��
	 * @param year ��
	 * @param month ��
	 * @return �����迭
	 * @throws SQLException
	 */
	public MonthVO[][] selectMonthEvent(String year, String month) throws SQLException {
		MonthVO[][] mvo = new MonthVO[31][];
		
		return mvo;
	}
	
	/**
	 * �̺�Ʈ �߰�
	 * @param dvo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO dvo) throws SQLException{
		
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
