package date181121;

public class TestDoWhile02 {

	public static void main(String[] args) {

		// �ԷµǴ� ������ ������ ���
		int input = Integer.parseInt(args[0]);

		if (input > 1 && input < 10) { // 2��~9�� ����
			int j = 1;
			do {
				System.out.println(input+" * "+j+" = "+input*j);
				j++;
			} while (j < 10);
		} else {
			System.out.println("���� 2�ܿ��� 9�ܱ��� �Է����ּ���");
		} 
	}
}
