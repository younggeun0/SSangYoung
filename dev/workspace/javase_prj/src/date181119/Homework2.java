package date181119;
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

public class Homework2 {
	
	public static void main(String[] args) {
		
		String name = args[0];
		String means = args[1];
		int distance = Integer.parseInt(args[2]);
		int fare = 0;
		int extraFare = 0;
		int faresPerMonth = 0;
		
		if (!(args[1].equals("����")||args[1].equals("����ö")
			|| args[1].equals("�ý�")|| args[1].equals("����"))) {
			System.out.println("����, ����ö, �ý�, ������ ��������̿���");
			System.exit(0);
		} else {
			if (distance >= 10) {
				extraFare = (int)((distance-10)/5)*100;
			}
			
			if (args[1].equals("����")) {
				fare = 1200 + extraFare;
			} else if (args[1].equals("����ö")) {
				fare = 1250 + extraFare;
			} else if (args[1].equals("�ý�")) {
				fare = 3800 + extraFare;
			}
		}
		
		faresPerMonth = fare*40;
		
		System.out.println(name + "�� ����� ��������� "
				+ means + "�̸� �Ÿ��� " + distance
				+ "km �Դϴ�. \n�� �̿� ����� "
				+ fare + "���̰�, �պ��̿� ����� "
				+ (fare*2) + "���̸�, \n�Ѵ� 20�� ���� ������ �� "
				+ faresPerMonth + "�� �Դϴ�.");
		
	}
}
