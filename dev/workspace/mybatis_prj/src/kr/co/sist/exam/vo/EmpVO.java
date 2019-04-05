package kr.co.sist.exam.vo;

public class EmpVO {

	private int deptno;
	private String job;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public EmpVO(int deptno, String job) {
		this.deptno = deptno;
		this.job = job;
	}
}
