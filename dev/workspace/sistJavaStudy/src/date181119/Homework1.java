package date181119;
/* ���� 
 1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���.
 	��� : ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ� �ٸ� "��Ÿ�"
	60�� ���϶�� "�ܰŸ�"�� ����ϼ���.
*/
public class Homework1 {
	
	public static void main(String[] args) {
		
		int toWork = Integer.parseInt(args[0]);
		int fromWork = Integer.parseInt(args[1]);
		
		int commuteTime = toWork + fromWork;
		
		if (commuteTime < 0 ) {
			System.out.println("����� �ϱ� �ϼ���?..");
		} else if (commuteTime > 120) {
			System.out.println("�ʹ� ���� �ɸ��ϴ�..����ϼ���");
		} else if (commuteTime <= 60) {
			System.out.println("�ܰŸ�");
		} else {
			System.out.println("��Ÿ�");
		}
	}

}
