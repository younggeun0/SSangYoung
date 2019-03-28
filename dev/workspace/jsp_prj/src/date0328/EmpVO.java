package date0328;

public class EmpVO {

	private int empno, sal;
	private String ename, job, hiredate;
	
	public EmpVO() {
	}
	
	public EmpVO(int empno, int sal, String ename, String job, String hiredate) {
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
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

	public String getHiredate() {
		return hiredate;
	}

	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", sal=" + sal + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate
				+ "]";
	}
}
