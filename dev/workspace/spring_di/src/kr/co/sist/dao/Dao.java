package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public interface Dao {
	public int insertEmp(EmpVO evo) throws SQLException;
	public List<EmpVO> selectEmp() throws SQLException;
}
