package kr.co.sist.vo;

public class DiaryListVO {
	
	private int num;
	private String subject, writer, e_year, e_month, e_date, w_date;
	
	public DiaryListVO(int num, String subject, String writer, String e_year, String e_month, String e_date,
			String w_date) {
		this.num = num;
		this.subject = subject;
		this.writer = writer;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_date = e_date;
		this.w_date = w_date;
	}

	public int getNum() {
		return num;
	}

	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}

	public String getE_year() {
		return e_year;
	}

	public String getE_month() {
		return e_month;
	}

	public String getE_date() {
		return e_date;
	}

	public String getW_date() {
		return w_date;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
