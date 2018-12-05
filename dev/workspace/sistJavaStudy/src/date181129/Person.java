package date181129;

public class Person {

	private int eye, nose, mouth;	// ������
	private String name;			// �̸�
	
	public Person() {
		this(2, 1, 1);
	}
	
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}

	public void setEye(int eye) {
		if (eye > 3) {
			this.eye = 2;
		} else {
			this.eye = eye;
		}
	}
	public void setNose(int nose) {
		this.nose = nose;
	}
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getEye() {
		return eye;
	}
	public int getNose() {
		return nose;
	}
	public int getMouth() {
		return mouth;
	}
	public String getName() {
		return name;
	}
	
	/**
	 * ������ ��� ��ü�� ������ ���� �Դ� ���� ����
	 * 
	 * @return ���
	 */
	public String eat() {
		return name+"��(��) ������ ���� �Դ´�.";
	}
	
	/**
	 * ������ ��� ��ü�� �Ĵ翡�� �ֹ��� ������ �Դ� ���� ����
	 * 
	 * @param menu ������ ����
	 * @param price ���İ���
	 * @return ���
	 */
	public String eat(String menu, int price) {
		return name+"��(��) �Ĵ翡�� "+menu
				+"�� ������ "+price+"�� ���� ��Դ´�.";
	}
}