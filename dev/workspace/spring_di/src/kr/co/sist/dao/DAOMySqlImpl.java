package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DAOMySqlImpl implements Dao {

	@Override
	public int insertEmp(EmpVO evo) throws SQLException {
		// MySql DB�� insert �۾� ����
		System.out.println("MySql�� ������� �߰�");
		return 1;
	}
	
	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		list.add(new EmpVO(2111, "������"));
		list.add(new EmpVO(2112, "������"));
		list.add(new EmpVO(2113, "������"));
		list.add(new EmpVO(2114, "�̺���"));
		
		return list;
	}
}
