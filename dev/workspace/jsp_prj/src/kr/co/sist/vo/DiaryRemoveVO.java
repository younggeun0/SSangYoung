package kr.co.sist.vo;

public class DiaryRemoveVO {
	
	private int num;
	private String pass;
	
	public DiaryRemoveVO(int num, String pass) {
		this.num = num;
		this.pass = pass;
	}

	public int getNum() {
		return num;
	}

	public String getPass() {
		return pass;
	}
}
