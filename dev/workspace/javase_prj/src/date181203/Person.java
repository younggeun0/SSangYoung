package date181203;

/**
 * Person�� �Ϲ�Ŭ�������� abstract Ŭ������ ����<br>
 * ��� ����� ������ �Դ��ϰ� �ۿ��� ��Դ���, �� �ݵ�� ������.
 * @author owner
 */
public abstract class Person {

	private int eye, nose, mouth;	// ������
	private String name;			// �̸�
	private String[] language;		// ����� ����ϴ� ���
	
	
	/**
	 * �� �߰��� �� �ֵ��� 
	 */
	public Person() {
		this(2, 1, 1);
	}
	
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
		this.language = new String[10];
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
	public String[] getLanguage() {
		return language;
	}
	
	/**
	 * ������ ��� ��ü�� ������ ���� �Դ� ���� ����
	 * 
	 * @return ���
	 */
	public abstract String eat(); 
	
	/**
	 * ������ ��� ��ü�� �Ĵ翡�� �ֹ��� ������ �Դ� ���� ����
	 * 
	 * @param menu ������ ����
	 * @param price ���İ���
	 * @return ���
	 */
	public abstract String eat(String menu, int price); /*{
		return name+"��(��) �Ĵ翡�� "+menu
				+"�� ������ "+price+"�� ���� ��Դ´�.";
	}*/
	
	/**
	 * ����� �� ������ �� �� �ִ�.
	 * @return �� �� �ִ� ���
	 */

//	public abstract String[] language(String lang);
	
	public String[] language(String lang) {
		String[] tempLang = getLanguage();

		int idx = 0;
		for (int i = 0; i < tempLang.length; i++) {
			// ������ �� �����Ѵٸ� ���� �ε����� ��´�
			if(tempLang[i] != null) { 
				if (lang.equals(tempLang[i])) { 
					// �Էµ� �� �̹� ������ ����� �ݺ����� ��������
					// �ش� �濡 ��� �� �ִ� �ε����� ����.
					break;
				}
				idx++;
			}
		}

		// ������ �߰��ǰ� �ִٸ� ����� : upsert
		tempLang[idx] = lang;
		return tempLang;
	}
	
	public abstract void paint();
	
	
	
}