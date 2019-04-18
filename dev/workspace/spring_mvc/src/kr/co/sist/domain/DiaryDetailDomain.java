package kr.co.sist.domain;

public class DiaryDetailDomain {
	
	private String writer, subject, content, w_date, ip;

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getW_date() {
		return w_date;
	}

	public String getIp() {
		return ip;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
