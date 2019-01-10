package date190110;

public class TransactionVO {
	
	private String subject, writer;

	public TransactionVO() {
	}
	
	public TransactionVO(String subject, String writer) {
		this.subject = subject;
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}
	public String getWriter() {
		return writer;
	}

	@Override
	public String toString() {
		return "TransactionVO [subject=" + subject + ", writer=" + writer + "]";
	}
}
