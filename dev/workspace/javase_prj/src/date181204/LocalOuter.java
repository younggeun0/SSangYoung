package date181204;

/**
 * method�ȿ� Ŭ������ �����ϴ� ����class ���.<br>
 * ������ ��ü�� ��������ó�� ����ϴ� Ŭ����
 * 
 * @author owner
 */
public class LocalOuter {

	int i;

	public LocalOuter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}

	public void method(int param_i, final int param_j) { // parameter�� ��������

		int local_i = 0;
		final int local_j = 0;

		/////////////////////// ���� Ŭ���� ���� //////////////////////////
		class Local {
			int loc_i;

			public Local() {
				System.out.println("���� Ŭ������ ������");
			}
			
			public void locMethod() {
				System.out.println("���� Ŭ������ method");
				System.out.println("�ܺ� Ŭ������ instance ���� i="+i);
				
				// jdk 1.8������ final�� ���� ���������� ��밡��
				System.out.println("�Ű�����(parameter) param_i="
						+param_i+", param_j="+param_j);
				System.out.println("�������� local_i="
						+local_i+", local_j="+local_j);
				// jdk1.8���ʹ� final�� ���� ���� ���������� ����� ����������
				// final�� ���� �ʾƵ� ���Ҵ��� ���� �ʴ´�(finaló�� ���) 
				// local_i = 2018;  
				// pram_i = 2018;
			}
		}
		/////////////////////// ���� Ŭ���� �� ////////////////////////////
		// ����Ŭ������ ����Ϸ��� �޼ҵ忡�� ����Ŭ���� ��üȭ �ʿ�
		
		// ����Ŭ������ ��üȭ
		Local lo = new Local();
		
		// ������ ��ü�� Ŭ������ �ڿ��� ����� �� �ִ�.
		// loc_i=100; // ���� ���Ұ�
		lo.loc_i=100;
		lo.locMethod();
		System.out.println(lo.loc_i);
		
		System.out.println("method ȣ��");
	}

	public static void main(String[] args) {

		LocalOuter lo = new LocalOuter();
		lo.method(4, 12);
	}
}
