/* ���� 
1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���.
	��� : ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ� �ٸ� "��Ÿ�"
	60�� ���϶�� "�ܰŸ�"�� ����ϼ���.
 */
package date181125;
public class HWRevision181119_1 {

	public static void main(String[] args) {
	
		int commuteMin = 65;
		
		if (commuteMin > 120) {
			System.out.println("�ʹ� ����� �ð��� ��ϴ�.");
		} else if (commuteMin > 60) {
			System.out.println("��Ÿ�");
		} else {
			System.out.println("�ܰŸ�");
		}
		
	}
}
