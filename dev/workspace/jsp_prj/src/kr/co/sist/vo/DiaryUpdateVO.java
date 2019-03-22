package kr.co.sist.vo;

public class DiaryUpdateVO {
	
	private int num;
	private String content, pass;
	
	public DiaryUpdateVO() {
	}
	
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

	public void setNum(int num) {
		this.num = num;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "DiaryUpdateVO [num=" + num + ", content=" + content + ", pass=" + pass + "]";
	}
}
