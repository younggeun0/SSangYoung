package kr.co.sist.assembly;

import kr.co.sist.dao.DAOMySqlImpl;
import kr.co.sist.dao.DAOOracleImpl;
import kr.co.sist.dao.Dao;
import kr.co.sist.service.Service;
import kr.co.sist.service.ServiceImpl;

/**
 * 의존성 주입 관계를 설정하는 일
 */
public class Assembly {

	public Service getBean() {
		
		// 1. 의존성 주입할 객체를 생성
		Dao dao = new DAOMySqlImpl();
		
		// 2. 의존성 주입받을 객체를 생성하면서 의존성 주입
		Service service = new ServiceImpl(dao);
		
		// 3. 의존성 주입받은 객체를 반환
		return service;
	}
}
