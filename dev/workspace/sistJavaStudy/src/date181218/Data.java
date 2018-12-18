package date181218;

public class Data implements Cloneable {

	private String school;

	public Data() {
		super();
	}

	public Data(String school) {
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public Data getData() throws CloneNotSupportedException {
		// clone()�� protected ���������ڸ� ������ �־�
		// �ܺ� Ŭ�������� �ٸ� Ŭ������ clone()�� ȣ���� �� ����.
		Data data = (Data)this.clone();
		return data;
	}
}
