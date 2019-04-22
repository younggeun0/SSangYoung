package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.Dao;
import kr.co.sist.vo.EmpVO;

public class ServiceImpl implements Service {
	
	// �ڽ��� �ƴ� �θ��� �̸����� ��ü�� �����ϸ� ��� �ڽ��� ���� �� �ִ�.
	// == ��ü������
	private Dao dao;

	// Service ��ü�� ������ ó���ϴµ� �ݵ�� Dao�� ����ؾ� �Ѵ�
	// == Service�� DAO�� �������� �ִ�.
	// (Service��ü�� ����Ϸ��� DAO�� ������ ���Թ޾ƾ� �Ѵ� == DI)
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public void addEmp(EmpVO evo) {
		try {
			// ���������� ó��
			System.out.println("�߰� �۾��� ���� �������� ó��");
			dao.insertEmp(evo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<EmpVO> searchEmp() {

		List<EmpVO> list = null;
		try {
			System.out.println("��ȸ�۾��� ���� �������� ó��");
			list = dao.selectEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
