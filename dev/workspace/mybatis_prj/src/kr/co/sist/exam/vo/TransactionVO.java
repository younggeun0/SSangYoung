package kr.co.sist.exam.vo;

public class TransactionVO {
	
	private String subject, writer;
	
	

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

	public TransactionVO(String subject, String writer) {
		this.subject = subject;
		this.writer = writer;
	}
}
