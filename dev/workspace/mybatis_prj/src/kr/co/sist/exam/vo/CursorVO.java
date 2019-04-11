package kr.co.sist.exam.vo;

import java.util.List;

import kr.co.sist.exam.domain.EmpProcedure;

public class CursorVO {
	
	private int deptno;
	private List<EmpProcedure> empList;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public List<EmpProcedure> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmpProcedure> empList) {
		this.empList = empList;
	}
}
