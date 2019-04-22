package kr.co.sist.service;

import java.util.List;

import kr.co.sist.vo.EmpVO;

public interface Service {
	public void addEmp(EmpVO evo);
	public List<EmpVO> searchEmp();
}
