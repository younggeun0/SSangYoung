package date0306;

public class EmpVO { // VO - Value Object
	
	private int empno, mgr,sal;
	private String ename, job, hiredate;
	
	public EmpVO(int empno, int mgr, int sal, String ename, String job, String hiredate) {
		this.empno = empno;
		this.mgr = mgr;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}

	public int getEmpno() {
		return empno;
	}

	public int getMgr() {
		return mgr;
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
		return "EmpVO [empno=" + empno + ", mgr=" + mgr + ", sal=" + sal + ", ename=" + ename + ", job=" + job
				+ ", hiredate=" + hiredate + "]";
	}
}
