package date181119;

public class TestIfElse {

	public static void main(String[] args) {
		
		int i = -23;
		
		// �������� �������� ������� �Ǵ�
		System.out.println(i + " ��(��) ");
		
		if (i < 0) {
			System.out.println("����");
		} else {
			System.out.println("���");
		}
		
		// �������� Ȧ������ ¦������ �Ǵ�
		// �����ϴ� ���� �� ���̶�� {}�� ��������
		if (i%2 == 0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}
		
		// �Է��ϴ� ���� 3�� ������ "3�� ���"�� ���
		// �׷��� �ʴٸ� �Է��� ���� ���
		
		if (i%3 == 0) {
			System.out.println("3�� ���");
		} else {
			System.out.println(i);
		}
	}
}
