package kr.co.sist.assembly;

import kr.co.sist.dao.DAOMySqlImpl;
import kr.co.sist.dao.DAOOracleImpl;
import kr.co.sist.dao.Dao;
import kr.co.sist.service.Service;
import kr.co.sist.service.ServiceImpl;

/**
 * ������ ���� ���踦 �����ϴ� ��
 */
public class Assembly {

	public Service getBean() {
		
		// 1. ������ ������ ��ü�� ����
		Dao dao = new DAOMySqlImpl();
		
		// 2. ������ ���Թ��� ��ü�� �����ϸ鼭 ������ ����
		Service service = new ServiceImpl(dao);
		
		// 3. ������ ���Թ��� ��ü�� ��ȯ
		return service;
	}
}
