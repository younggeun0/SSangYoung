package date181204;

/**
 *
 * @author owner
 */
public class Outer {
	
	int i;

	public Outer() {
		System.out.println("�ٱ� Ŭ������ ������");
	}
	
	public void outMethod() {
		System.out.println("�ٱ� Ŭ������ method, i="+i);
		// ����Ŭ������ ��üȭ
		Outer.Inner in = this.new Inner();
		in.inMethod();
	}
	
	////////////////////// ���� Ŭ���� ���� ////////////////////////
	public class Inner {
		int j;
		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}
		public void inMethod() {
			// ����Ŭ�������� �ٱ�Ŭ������ ����, method�� ��밡��
			System.out.println("���� Ŭ������ method, j="
					+j+", �ٱ� Ŭ������ �ڿ� i="+i);
		}
	}
	////////////////////// ���� Ŭ���� �� //////////////////////////
	
	public static void main(String[] args) {

		// 1. �ٱ� Ŭ������ ��üȭ
		Outer out = new Outer();
		out.i = 10;
		out.outMethod();
		
		// ����Ŭ������ �ڿ��� ���� ���ٻ��Ұ�
		// out.j = 20; 
		// out.inMethod();
		
		// 2. ���� Ŭ������ ��üȭ(�ٱ� Ŭ���� ��ü���)
		// �ٱ�Ŭ������.����Ŭ������ ��ü�� = �ٱ�Ŭ�����ǰ�ü��.new ���ʻ�����();
		// Outer.Inner in = out.new Inner(); // �ٱ�Ŭ�������� ������ �� �ִ�.
		/*Inner in = out.new Inner();
		
		in.j = 12;
		in.inMethod();*/
	}
}
