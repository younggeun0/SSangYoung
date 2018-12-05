package date181204;

/**
 * ����Ŭ������ static ����ó�� ����� �� �ִ� ��øŬ����(nested class)
 * 
 * @author owner
 */
public class NestedOuter {
	
	int i;
	static int j;

	public NestedOuter() {
		System.out.println("�ٱ�Ŭ���� ������");
	}
	
	public void outInstanceMethod() {
		System.out.println("�ٱ�Ŭ������ instance method");
	}
	
	public static void outStaticMethod() {
		System.out.println("�ٱ�Ŭ������ static method");
	}
	
	/////////////////////// Nested class ���� ///////////////////
	public static class NestedInner {
		// int instance_i; // instance ����, instance ���� �������
		static int instance_j; // static ����
		
		/*public NestedInner() { // ������ �������(static Ŭ�����̹Ƿ�)
			System.out.println("��øŬ���� ������");
		}*/
		
		public void inMethod() { // ��üȭ���� ���Ұ�
			System.out.println("���� Ŭ������ instance method");
		}
		
		public static void inStaticMethod() {
			System.out.println("���� Ŭ������ static method");
			// i�� �ν��Ͻ� ������ ���� ���Ұ�(��üȭ �ʿ�)
			System.out.println("�ٱ�Ŭ������ �ڿ� ��� "
					+ "i=���Ұ�, j="+NestedOuter.j); 
			// outInstanceMethod(); // �ν��Ͻ� �޼ҵ�� ���Ұ�
			NestedOuter.outStaticMethod();
		}
	}
	/////////////////////// Nested class �� /////////////////////
	
	public static void main(String[] args) {

		// static ������ ����� ������ ��üȭ���� Ŭ������.������,
		// Ŭ������.method������ ���(static ���)
		
		// NestedInner.inMethod(); // ��üȭ ���ؼ� ���Ұ�
		NestedInner.inStaticMethod();
		
		// ��øŬ������ ��üȭ �������(static �̹Ƿ�)
		// NestedInner ni = new NestedInner();
		// System.out.println(ni.instance_i);
		
	}
}
