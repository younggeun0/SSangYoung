package kr.co.sist.vo;

public class MonthVO {

	private int num;
	private String subject;
	
	public MonthVO(int num, String subject) {
		this.num = num;
		this.subject = subject;
	}

	public int getNum() {
		return num;
	}

	public String getSubject() {
		return subject;
	}
}
