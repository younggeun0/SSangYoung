package date190104;

public class CpDeptVO {

	private int deptno;
	private String dname, loc;
	
	public CpDeptVO() {
	}
	
	public CpDeptVO(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}
	public String getDname() {
		return dname;
	}
	public String getLoc() {
		return loc;
	}
}
