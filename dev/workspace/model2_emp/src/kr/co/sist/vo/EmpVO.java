package kr.co.sist.vo;

public class EmpVO {
	
	private int empno, sal;
	private String name, job, hiredate;
	
	public EmpVO() {}
	
	public EmpVO(int empno, int sal, String name, String job, String hiredate) {
		this.empno = empno;
		this.sal = sal;
		this.name = name;
		this.job = job;
		this.hiredate = hiredate;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", sal=" + sal + ", name=" + name + ", job=" + job + ", hiredate=" + hiredate
				+ "]";
	}
}
