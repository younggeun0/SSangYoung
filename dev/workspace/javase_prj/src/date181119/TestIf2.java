package date181119;

public class TestIf2 {
	
	public static void main(String[] args) {
		
		// �̸��� �Է¹޾� �̸��� "������"�̸� �̸��� ����ϱ� ��
		// "����"�� ���, �׷��� ������ �̸��� ���
		
		if (args[0].equals("������")) {
			System.out.print("���� ");
		}
		
		System.out.println(args[0]);
		
		// ���������� ���ڿ��� ������ ��ȯ
		int i = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		int r = Integer.parseInt(args[3]);
		
		System.out.println(i+"+"+j+"+"+r+"="+(i+j+r));
		
	}

}
