package kr.co.sist.vo;

public class DiaryUpdateVO {
	
	private int num;
	private String content, pass;
	
	public DiaryUpdateVO(int num, String content, String pass) {
		this.num = num;
		this.content = content;
		this.pass = pass;
	}

	public int getNum() {
		return num;
	}

	public String getContent() {
		return content;
	}

	public String getPass() {
		return pass;
	}
}
