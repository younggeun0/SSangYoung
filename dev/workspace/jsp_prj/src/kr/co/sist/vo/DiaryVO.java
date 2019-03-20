package kr.co.sist.vo;

public class DiaryVO {

	private String writer, subject, content, e_year, e_month, e_date, pass, ip;

	public DiaryVO(String writer, String subject, String content, String e_year, String e_month, String e_date,
			String pass, String ip) {
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_date = e_date;
		this.pass = pass;
		this.ip = ip;
	}

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
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

	public String getPass() {
		return pass;
	}

	public String getIp() {
		return ip;
	}
}
