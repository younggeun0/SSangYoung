package date181130;

public class Young extends Person {
	
	public Young() {
		this.setName("������");
	}
	
	public String coding() {
		return "�ڵ��մϴ�..";
	}
	
	public String idle() {
		return "�۶����ϴ�..";
	}
	
	public String beAsked(int questionNum) {
		String msg;
		if (questionNum >= 7) {
			msg = "������ ���� ������..~(_-_)~";
		} else if (questionNum >= 4) {
			msg = "������ ������";
		} else if (questionNum <= 4 && questionNum > 0) {
			msg = "������ ���� �ֱ���";
		} else {
			msg = "������ �����^.^";
		}
		return msg;
	}
	
	@Override
	public String eat() {
		//��������(��) ������ ���� �Դ´�.
		return getName()+"��(��) �ѵ����� ���Ͽ� ���� ���� �Դ´�.";
	}

}
