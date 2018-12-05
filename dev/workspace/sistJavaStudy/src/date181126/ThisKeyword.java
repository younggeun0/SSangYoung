package date181126;

/**
 * method�� ȣ���ϴ� ��ü�� �ּҷ� ����Ǿ� ���Ǵ� this
 * 
 * @author owner
 */
public class ThisKeyword {

	int i;
	
	/**
	 * parameter�� �̸��� instance������ �̸��� ���� �� 
	 * this�� ������� �ʰ� �Ķ������ ���� instance������ ������ �� 
	 * @param i  ������ ��
	 * @param tk �ν��Ͻ��ּ�
	 */
	public void useInstance(int i, ThisKeyword t) {
		// �Ķ���� ������ ���� �ν��Ͻ������� �Ҵ��ϰڽ��ϴ�.
		// == stack�� ���� heap�� ������ �ø��ڽ��ϴ�.
		System.out.println("���޹��� ��ü t:"+t);
		t.i = i;
	}
	
	/**
	 * �Ķ������ �̸��� �ν��Ͻ������� �̸��� ���������� ��ü�� �ѱ��
	 * �޾Ƽ� ����Ϸ��� �ڵ��� �������� ���ݵ�. <br>
	 * �̸� �����ϱ����� this�� ������.<br>
	 * this�� ȣ���� ��ü�� �ּҷ� �����, �Ű������� ��ü�� ���� 
	 * �ʿ䰡 ������!
	 * 
	 * @param i ������ ��
	 */
	public void useThis(int i) {
		// this�� �޼ҵ带 ȣ���ϴ� ��ü�� �ּҷ� �ٲ��.
		// �Ű������� ��ü�� ���� �ʿ䰡 ����.
		this.i = i;
		System.out.println("�޼ҵ带 ȣ���� ��ü�� �ּ� : "+this);
	}
	
	public static void test() {
		// static method �ȿ����� this Ű���带 ����� �� ����.
		// this.i = 10; // error!
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		
		ThisKeyword tk = new ThisKeyword();
		System.out.println("������ ��ü tk:"+tk);
		
		tk.useInstance(10, tk);
		System.out.println("������ ��ü�� �ν��Ͻ������� �� "+tk.i);
		
		System.out.println("===========================================");
		
		tk.useThis(3300);
		System.out.println("this�� ����Ͽ� ������ �ν��Ͻ������� �� "+tk.i);
		
		ThisKeyword.test();
	}
}
