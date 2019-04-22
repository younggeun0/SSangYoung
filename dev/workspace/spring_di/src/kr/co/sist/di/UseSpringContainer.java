package kr.co.sist.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.ServiceImpl;
import kr.co.sist.vo.EmpVO;

public class UseSpringContainer {

	public static void main(String[] args) {
		
		// 1. ���������� ����Ͽ� Spring Container����
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/applicationContext.xml");
		
		// 2. id�� ����Ͽ� Bean(������ ���Թ��� ��ü) ���
		// ServiceImpl si = (ServiceImpl)ac.getBean("service");
		ServiceImpl si = ac.getBean("service",ServiceImpl.class);
		
		// 3. ã�Ƴ� Bean�� ����Ͽ� ���
		si.addEmp(new EmpVO(3333, "������"));
	
		List<EmpVO> list = si.searchEmp();
		for(EmpVO ev : list) {
			System.out.println(ev.getEmpno()+"/"+ev.getEname());
		}
	}
}
