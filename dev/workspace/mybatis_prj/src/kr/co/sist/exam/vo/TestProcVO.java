package kr.co.sist.exam.vo;

/**
 * Procedure에 사용되는 VO는
 * in parameter와 out parameter 값을
 * 모두 갖고 있어야 한다.
 */
public class TestProcVO {

	private String ename, job, msg;
	private int empno, sal, rowCnt;

	public TestProcVO(String ename, String job, String msg, int empno, int sal, int rowCnt) {
		this.ename = ename;
		this.job = job;
		this.msg = msg;
		this.empno = empno;
		this.sal = sal;
		this.rowCnt = rowCnt;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getRowCnt() {
		return rowCnt;
	}
	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}
}
