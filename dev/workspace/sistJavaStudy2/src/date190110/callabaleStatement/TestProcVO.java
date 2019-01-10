package date190110.callabaleStatement;

public class TestProcVO {
	
	private int empno, sal;
	private String ename, job;
	
	public TestProcVO() {
		
	}
	
	public TestProcVO(int empno, int sal, String ename, String job) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
	}

	public int getEmpno() {
		return empno;
	}
	public int getSal() {
		return sal;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
}
