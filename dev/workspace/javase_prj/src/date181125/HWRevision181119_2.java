package date181125;
/*
 * 2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ���� ����ϼ���.
 * 	    ��������� "����,����ö,�ý�,����"�� �����Ѵ�.
 * 	    ������� 1200��, ����ö ��� 1250��, �ýÿ�� 3800�� �Դϴ�.
 *    ����� 10Ű�� ������ �⺻���, �� 5Ű�� �ʰ��� ���� 100���� ���� �մϴ�.
 *
 * ���  : xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű�� �Դϴ�.
 *       �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�, �Ѵ� 20�ϱ���
 *       ������ ��: xxxx�� �Դϴ�.
 */

public class HWRevision181119_2 {

	public static void main(String[] args) {
		
		String name = "young";
		String mean = "����";
		int fare = 0;
		int extraFare = 0;
		int commuteDis = 24;
		
		if (!(mean.equals("����") || mean.equals("����ö") || mean.equals("����") || mean.equals("�ý�"))) {
			System.out.println("���� ������ ����, ����ö, ����, �ýø� ���ð����մϴ�.");
		} else {
			
			if (commuteDis > 10) {
				extraFare = ((commuteDis-10)/5)*100;
			}
			
			if (mean.equals("�ý�")){
				fare = 3800 + extraFare;
			} else if (mean.equals("����")){
				fare = 1200 + extraFare;
			} else if (mean.equals("����ö")){
				fare = 1250 + extraFare;
			}
			
			System.out.printf("%s�� ����� ��������� %s�̸� �Ÿ��� %dŰ�� �Դϴ�.\n"
					+ "�� �̿� ��� %d���̰�, �պ��̿� ��� %d���̸�, �Ѵ� 20�� ����\n"
					+ "������ �� : %d�� �Դϴ�.", name, mean, commuteDis, fare, fare*2, fare*20);
		}
	}
}
