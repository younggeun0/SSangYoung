package date181119;

public class TestElseIf {

	public static void main(String[] args) {
		
		int i = Integer.parseInt(args[0]);
		
		System.out.println(i + "��(��) ");
		
		if (i < 0) {
			System.out.println("0���� �۾Ƽ� �Է½���");
		} else if (i > 100) {
			System.out.println("100���� Ŀ�� �Է½���");
		} else {
			System.out.println("�Է� ����");
		}
	}
}

