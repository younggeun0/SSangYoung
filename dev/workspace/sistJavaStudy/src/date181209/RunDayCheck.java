package date181209;
/*
���� 1.
main method�� arguments�� ��¥�� ������ �Է� �޾� �Է¹��� ��¥��
������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.

��) java Test 4 12 30 32 35 15 4   

���) 4 ȭ
     12 ��
     15 ��
     30 ��  
  
*/
public class RunDayCheck {

	public static void main(String[] args) {
		
		DayCheck dc = new DayCheck();
		dc.printDayAndDayOfWeek(dc.setDay(args));
	}
}
