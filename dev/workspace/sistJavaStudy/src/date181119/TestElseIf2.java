package date181119;

public class TestElseIf2 {

	public static void main(String[] args) {
		//�̸��� �Է¹޾� "������" �̸� ������
		//�̺��� �ڿ��� ������ ������ �̸� "����"��
		//�׷��� ������ "���"�� �̸��տ� ��� �ϼ���  
		
		if (args[0].equals("������")) {
			System.out.print("���� ");
		} else if (args[0].equals("�̺���") 
				|| args[0].equals("�ڿ���")
				|| args[0].equals("������")
				|| args[0].equals("������")) {
			System.out.print("���� ");
		} else {
			System.out.print("��� ");
		}
		
		System.out.println(args[0] + "�� �ȳ��ϼ���.");
	}
}
