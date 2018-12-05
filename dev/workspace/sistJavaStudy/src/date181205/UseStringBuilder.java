package date181205;

/**
 * StringBuffer, StringBuilder(jdk 1.5)
 * ���ڿ��� heap�� ���� �����ϰ� ����ϴ� Ŭ����
 * @author owner
 */
public class UseStringBuilder {
	
	public void useStringBuffer() {
		// Ŭ���� ����
		StringBuffer sb = new StringBuffer();

		// ��(����, �Ǽ�, ����, ���ڿ�, �Ҹ�)�� �߰��ϴ� append method
		sb.append("������ ");
		sb.append(12);
		sb.append("�� 5��").append(" ������ �Դϴ�.");
		System.out.println(sb);

		// �� ����
		sb.insert(sb.indexOf(" "), " 2018��");
		System.out.println(sb);
		
		// �� ����
		sb.delete(sb.indexOf("2"), sb.indexOf("��")+1);
		System.out.println(sb);

		// ���ڿ� ������
		sb.reverse();
		System.out.println(sb);

		// �ٽ� �������� �������� ���ƿ�
		sb.reverse();
		System.out.println(sb);
	}
	
	public void useStringBuilder() {
		StringBuilder sb = new StringBuilder();

		sb.append("������ ");
		sb.append(12);
		sb.append("�� 5��").append(" ������ �Դϴ�.");
		System.out.println(sb);

		sb.insert(sb.indexOf(" "), " 2018��");
		System.out.println(sb);
		
		sb.delete(sb.indexOf("2"), sb.indexOf("��")+1);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}
	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		
		System.out.println("StringBuffer�� StringBuilder�� ������ ����");
		System.out.println("--------------------------------");
		usb.useStringBuffer();
		System.out.println("--------------------------------");
		usb.useStringBuilder();
		
		
		
		String str = "�ȳ��ϼ���."; // ª�� ���ڿ�
		System.out.println(str);
		
		String str1 = "��";
		// ���ڿ��� '+'�� �پ �� ���ڿ��� �ȴ�.
		System.out.println(str1+"��"+"��"+"��"+"��"+".");
		// new StringBuilder().append(str1).append("��").append("��")...;
	}
}
