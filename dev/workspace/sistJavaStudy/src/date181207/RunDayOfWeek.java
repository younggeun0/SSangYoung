package date181207;
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
public class RunDayOfWeek {

	public static void main(String[] args) {
		
		CheckDayOfWeek hw = new CheckDayOfWeek();
		hw.setDate(args);
		hw.printDate(hw.map);
		
	}
}
