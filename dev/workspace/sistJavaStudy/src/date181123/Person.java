package date181123;

/**
 * ����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 * ����� Ư¡ : ��, ��, ��, �̸�<br>
 * ������ Ư¡ : �Դ´�
 * 
 * @author owner
 */
public class Person {

	private int eye, nose, mouth;	// ������
	private String name;			// �̸�
	
	/**
	 * ���Ŭ������ �⺻ ������<br>
	 * �� 2��, �� 1��, �� 1���� ���� ��� ��ü�� ����
	 * 11-26-2018 �ڵ� �߰�
	 */
	public Person() {
		this(2, 1, 1);
//		eye = 2;
//		nose = 1;
//		mouth = 1;
	}
	
	/**
	 * �� 2��, �� 1��, �� 1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������
	 * @param eye ���� ��
	 * @param nose ���� ��
	 * @param mouth ���� ��
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}

	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��<br>
	 * ������ ���� ������ �ִ� 3������ ������ �� �ִ�.<br>
	 * 3���� �Ѿ�� 2���� �����ȴ�.
	 * @param eye ������ ���� ��
	 */
	public void setEye(int eye) {
		if (eye > 3) {
			this.eye = 2;
		} else {
			this.eye = eye;
		}
	}
	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��
	 * 
	 * @param nose ������ ���� ��
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}
	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��
	 * 
	 * @param mouth ������ ���� ��
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��
	 * 
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ������ ��� ��ü�� ���� ���� ��ȯ�ϴ� ��
	 * 
	 * @return ���� ��ü�� ���� ���� ��
	 */
	public int getEye() {
		return eye;
	}
	/** 
	 * ������ ��� ��ü�� ���� ���� ��ȯ�ϴ� �� 
	 * @return ���� ��ü�� ���� ���� ��
	 */
	public int getNose() {
		return nose;
	}
	/**
	 * ������ ��� ��ü�� ���� ���� ��ȯ ��
	 * 
	 * @return ���� ��ü�� ���� ���Ǽ�
	 */
	public int getMouth() {
		return mouth;
	}
	/**
	 * ������ ��� ��ü�� �̸��� ��ȯ�ϴ� ��
	 * 
	 * @return ���� ��ü�� �̸� 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ������ Ư¡ <br>
	 * ������ ��� ��ü�� ������ ���� �Դ� ���� ����
	 * 
	 * @return ���
	 */
	public String eat() {
		return name+"��(��) ������ ���� �Դ´�.";
	}
	
	/**
	 * method overload : ������ - ���� �̸��� �޼ҵ带 
	 * ������ �����ϴ� ���<br>
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
