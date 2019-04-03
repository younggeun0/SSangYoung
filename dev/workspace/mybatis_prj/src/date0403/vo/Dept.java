package date0403.vo;

public class Dept {
	
	private int deptno;
	private String dname, loc;
	
	public Dept() {
		
	}
	
	public Dept(int deptno, String dname, String loc) {
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
