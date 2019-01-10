package date190110.callabaleStatement;

public class TestProcOneVO {
	
	private int sal;
	private String ename, hiredate, job;
	
	public TestProcOneVO() {
	}
	
	public TestProcOneVO(int sal, String ename, String hiredate, String job) {
		this.sal = sal;
		this.ename = ename;
		this.hiredate = hiredate;
		this.job = job;
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
		return "TestProcOneVO [sal=" + sal + ", ename=" + ename + ", hiredate=" + hiredate + ", job=" + job + "]";
	}
}
