package date181119;

public class TestElseIf3 {

	public static void main(String[] args) {
		
		//�¾�ظ� �Է¹޾� ��(12) ���ϱ�
		//11-��, 10-��, 9-��, 8-��, 7-�䳢, 6-ȣ����, 5-��, 4-��, 3-����,
		//2-��, 1-��, 0-������
		int input = Integer.parseInt(args[0]);
		
		if (input%12 == 11) {
			System.out.println("��");
		} else if (input%12 == 10) {
			System.out.println("��");
		} else if (input%12 == 9) {
			System.out.println("��");
		} else if (input%12 == 8) {
			System.out.println("��");
		} else if (input%12 == 7) {
			System.out.println("�䳢");
		} else if (input%12 == 6) {
			System.out.println("ȣ����");
		} else if (input%12 == 5) {
			System.out.println("��");
		} else if (input%12 == 4) {
			System.out.println("��");
		} else if (input%12 == 3) {
			System.out.println("����");
		} else if (input%12 == 2) {
			System.out.println("��");
		} else if (input%12 == 1) {
			System.out.println("��");
		} else {
			System.out.println("������");
		}
		
	}
}
