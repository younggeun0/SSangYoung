package kr.co.sist.vo;

public class MemberUpdateVO {
	
	private int num;
	private String name, highschool, loc;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHighschool() {
		return highschool;
	}
	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "MemberUpdateVO [num=" + num + ", name=" + name + ", highschool=" + highschool + ", loc=" + loc + "]";
	}
}
