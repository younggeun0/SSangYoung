package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.Dao;
import kr.co.sist.vo.EmpVO;

public class ServiceImpl implements Service {
	
	// 자식이 아닌 부모의 이름으로 객체를 저장하면 모든 자식을 받을 수 있다.
	// == 객체다형성
	private Dao dao;

	// Service 객체는 업무를 처리하는데 반드시 Dao를 사용해야 한다
	// == Service는 DAO에 의존성이 있다.
	// (Service객체를 사용하려면 DAO를 의존성 주입받아야 한다 == DI)
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public void addEmp(EmpVO evo) {
		try {
			// 업무로직을 처리
			System.out.println("추가 작업에 대한 업무로직 처리");
			dao.insertEmp(evo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<EmpVO> searchEmp() {

		List<EmpVO> list = null;
		try {
			System.out.println("조회작업에 대한 업무로직 처리");
			list = dao.selectEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
