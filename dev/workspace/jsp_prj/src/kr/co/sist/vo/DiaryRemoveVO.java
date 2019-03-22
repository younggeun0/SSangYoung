package kr.co.sist.vo;

public class DiaryRemoveVO {
	
	private int num;
	private String pass;
	
	public DiaryRemoveVO() {
	}
	
	
	public int getNum() {
		return num;
	}

	public String getPass() {
		return pass;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "DiaryRemoveVO [num=" + num + ", pass=" + pass + "]";
	}
}
