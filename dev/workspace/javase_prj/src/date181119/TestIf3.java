package date181119;

public class TestIf3 {

	//Constant : ������ ���ó�� ����� �� (���� �������� ���ϴ� ����)
	public static final int FLAG_VALUE = 1250;
	public static final int FLAG_CNT = 20;
	
	public static void main(String[] args) {
	
		// args[0]�� �Է¹޾� �� ���� 
		// 20���� ������ 1250�� �Է°��� ���Ͽ� ���
		// 20���� ũ�ٸ� 1250�� 1250�� 10%�� ���� ���� �Է°��� ���Ͽ� ���
		
		int input = Integer.parseInt(args[0]);
		int some_value = TestIf3.FLAG_VALUE;
		
		if (input > TestIf3.FLAG_CNT) {
			some_value = (int)(TestIf3.FLAG_VALUE 
								+ TestIf3.FLAG_VALUE*0.1);  
		}
		
		System.out.println(some_value * input);
	}
}
