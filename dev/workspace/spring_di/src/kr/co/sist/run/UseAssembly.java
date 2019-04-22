package kr.co.sist.run;

import java.util.List;

import kr.co.sist.assembly.Assembly;
import kr.co.sist.service.Service;
import kr.co.sist.vo.EmpVO;

/**
 * 조립자 클래스(Assembly)를 사용하여 서비스 객체를 얻고
 * 서비스를 사용하는 일을 한다
 */
public class UseAssembly {
	
	public static void main(String[] args) {
		Assembly as = new Assembly();
		Service service = as.getBean();
		service.addEmp(new EmpVO(3111, "피카츄"));
		
		System.out.println("-----------------------");
		List<EmpVO> list = service.searchEmp();
		
		for(EmpVO emp : list) {
			System.out.println(emp.getEmpno()+" / "+emp.getEname());
		}
	}
}
