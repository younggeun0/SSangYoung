/*
* 2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ����  ����ϼ���.
*       ��������� "����,����ö,�ý�,����"�� �����Ѵ�.
*       ������� 1200��, ����ö ��� 1250��, �ýÿ��  3800�� �Դϴ�.
*    ����� 10Ű�� ������ �⺻���, �� 5Ű�� �ʰ��� ����  100���� ���� �մϴ�.
*
* ���  : xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű��  �Դϴ�.
*       �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�,  �Ѵ� 20�ϱ���
*       ������ ��: xxxx�� �Դϴ�.
*       
*       switch ����ؼ� �����غ���
*/
package date181120;

public class Homework2Revision {
	
	public static void main(String[] args) {
		
		String name = args[0];
		String mean = args[1];
		int distance = Integer.parseInt(args[2]);
		
		int fare = 0;
		int extraFare = 0;
		int farePerMonth = 0;
		
		if (distance >= 10) {
			extraFare = (int)((distance-10)/5)*100;
		}
		
		switch (mean) {
			case "����" :
				fare = 1200 + extraFare;
				break;
			case "����ö":
				fare = 1250 + extraFare;
				break;
			case "�ý�":
				fare = 3800 + extraFare;
				break;
			case "����":
				break;
			default :
				System.out.println(args[1]+"��(��) ��������� �ƴմϴ�..");
		}
		
		farePerMonth = fare*20;
		
		System.out.println(name+"�� ����� ��������� "+mean
				+"�̸� �Ÿ��� "+distance+"km�Դϴ�. \n�� �̿� �����"
				+fare+"���̰�, �պ��̿� ����� "+(fare*2)
				+"�̸�, \n�Ѵ� 20�� ���� ������ �� "+farePerMonth+"���Դϴ�.");
		
		
	}

}
