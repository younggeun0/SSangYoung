package kr.co.sist.domain;

public class DiaryDomain {
	
	private String subject, writer, e_year, e_month, e_date, w_date;
	private int num;
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getE_year() {
		return e_year;
	}
	public void setE_year(String e_year) {
		this.e_year = e_year;
	}
	public String getE_month() {
		return e_month;
	}
	public void setE_month(String e_month) {
		this.e_month = e_month;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	public String getW_date() {
		return w_date;
	}
	public void setW_date(String w_date) {
		this.w_date = w_date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
