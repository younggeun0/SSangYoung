package date190110.callabaleStatement;

public class TestProcAllVO {

	private int empno, sal;
	private String ename, hiredate, job;

	public TestProcAllVO() {
	}

	public TestProcAllVO(int empno, int sal, String ename, String hiredate, String job) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
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

	public String getHiredate() {
		return hiredate;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "TestProcAllVO [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", hiredate=" + hiredate
				+ ", job=" + job + "]";
	}
	
	
}
