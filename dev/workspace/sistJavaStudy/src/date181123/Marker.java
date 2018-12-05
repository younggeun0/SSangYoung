package date181123;

/**
 * ��ī���� ������� �����Ͽ� �߻�ȭ�� �����Ͽ� ������� Ŭ����<br>
 * ��ī���� ����� Ư¡ : ��, ��ü, �Ѳ� =&gt; ����<br>
 *          ������ Ư¡ : ���� =&gt; method<br>
 * 
 * class�� ��������� �ڷ���, ������ ���������̴�.<br>
 * 
 * @author owner
 */
public class Marker {

	// ����� Ư¡(����)
	private String color;	// ��ī���� ��
	private int body;		// ��ī���� ��ü�� ����
	private int cap;		// ��ī���� �Ѳ��� ����

	/**
	 *  �⺻ �����ڷ� ��ī�� ��ü�� �����Ǹ� ������, 
	 *  �Ѳ�1��, ��ü1���� ��ī�� ��ü�� �����մϴ�.<br>
	 *  11-26-2018 �ڵ� �߰�
	 */
	public Marker() {
		this("������",1,1);
		System.out.println("Marker �⺻ ������");
		/*color = "������";
		body = 1;
		cap = 1;*/
	}
	
	/**
	 * �����ִ� ������ - ������, �Ѳ��� ��ü�� 1���� �ƴ� 
	 * ��ī���� ������ �� ����ϴ� ������<br>
	 * ��, �Ѳ��� ��, ��ü�� ���� �Է¹޾� ��ī���� �����ϴ� ������
	 * @param color ��ī�� ��
	 * @param cap �Ѳ��� ��
	 * @param body ��ü�� ��
	 * 11-26-2018 �ڵ� �߰�
	 */
	public Marker(String color, int cap, int body) {
		this.color = color;
		this.body = body;
		this.cap = cap;
		System.out.println("Marker �Ű����� �ִ� ������");
	}
	
	// setter
	/**
	 * ������ ��ī�� ��ü�� ���� �����ϴ� ���� ��
	 * ������, �Ķ���, �������� ����. �� ���� ���� ���������� ó��
	 * 
	 * @param color ��
	 */
	public void setColor(String color) {
		// �ν��Ͻ������� ������ ���� ���� ���� ����
		if (color.equals("������") || color.equals("�Ķ���")) 
			this.color = color;
		else
			this.color = "������";
	}
	/**
	 * ������ ��ī�� ��ü�� ��ü�� ������ �����ϴ� ��
	 * @param body ��ü�� ����
	 */
	public void setBody(int body) {
		this.body = body;
	}
	/**
	 * ������ ��ī�� ��ü�� �Ѳ��� ������ �����ϴ� ��
	 * @param cap �Ѳ��� ����
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}
	
	// getter
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� ���� ��ȯ
	 * @return ��
	 */
	public String getColor() {
		return color;
	}
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� ��ü ���� ��ȯ
	 * @return ��ü ��
	 */
	public int getBody() {
		return body;
	}
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� �Ѳ� ���� ��ȯ
	 * @return �Ѳ� ��
	 */
	public int getCap() {
		return cap;
	}
	
	// ������ Ư¡(�޼ҵ�)
	/**
	 * �Էµ� �޽����� ������ ��ī������ ĥ�ǿ� ���� ��
	 * 
	 * @param msg ĥ�ǿ� �� �޽���
	 * @return ���
	 */
	String write(String msg) {
		return color+"�� ��ī������ ĥ�ǿ� \""+msg+"\" �� ����";
	}
}
