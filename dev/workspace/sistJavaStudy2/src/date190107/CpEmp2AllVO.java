package date190107;

public class CpEmp2AllVO {
	
	private int empno, sal;
	private String ename, hiredate;
	
	public CpEmp2AllVO() {
	}
	
	public CpEmp2AllVO(int empno, int sal, String ename, String hiredate) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
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
	public String getHiredate() {
		return hiredate;
	}
}
