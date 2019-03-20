package kr.co.sist.vo;

public class DiaryDetailVO {
	
	private String writer, subject, content, w_date, ip;

	public DiaryDetailVO(String writer, String subject, String content, String w_date, String ip) {
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.w_date = w_date;
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

	public String getW_date() {
		return w_date;
	}

	public String getIp() {
		return ip;
	}
}
