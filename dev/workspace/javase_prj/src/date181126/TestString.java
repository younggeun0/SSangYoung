package date181126;

/**
 * ���ڿ��� ���� ��
 * 
 * @author owner
 */
public class TestString {

	public static void main(String[] args) {
	
		// �⺻�� ������ ���
		String str1 = "ABC"; 
		
		// �⺻�� �������� ������ ���ڿ��� ���ڿ� ������� �ּҸ� �����ϱ� 
		// ������ == �񱳷� ������ �񱳼����� �� �ִ�.
		if (str1 == "ABC") {
			System.out.println("�⺻�� == ����");		
		} else {
			System.out.println("�⺻�� == �ٸ�");
		}
		
		// ������ ������ ���
		String str2 = new String("ABC");

		// ������ �������� ����ϸ� ������ heap�ּҸ� �����ϰ�
		// heap�� ������� ��ü�� ���ڿ� ������� �ּҸ� �����Ѵ�.
		if (str2 == "ABC") {
			System.out.println("������ == ����");		
		} else {
			System.out.println("������ == �ٸ�");	
		}
		
		System.out.println("----------------------");
		
		if (str1.equals("ABC")) {
			System.out.println("�⺻�� equals �� ����.");
		} else {
			System.out.println("�⺻�� equals �� �ٸ�.");
		}
		
		if (str2.equals("ABC")) {
			System.out.println("������ equals �� ����.");
		} else {
			System.out.println("������ equals �� �ٸ�.");
		}
	}
}
