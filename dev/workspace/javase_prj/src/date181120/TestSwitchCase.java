package date181120;

/**
 *  switch~case�� ����� ���� ���ϱ�
 */
public class TestSwitchCase {
	
	public static void main(String[] args) {

        // char�� ���鹮��(white space)�� �ʱ�ȭ
		// ���鹮�� unicode \u0000
		// ''�� ���ھ���, error
		char grade = ' ';
		int score = Integer.parseInt(args[0]);
		

		System.out.println(grade);
		// �ڹٿ��� ����/���� = ����
		switch(score/10) {
		case 10 :
		case 9  : grade = 'A'; break;
		case 8  : grade = 'B'; break;
		case 7  : grade = 'C'; break;
		case 6  : grade = 'D'; break;
		default : grade = 'F';
		// default�� �Ʒ��ٿ� ����� �ڵ尡 �����Ƿ� �б⹮�� ������� �ʴ´�.
		}
		
		System.out.println(score+"���� "+ grade+" ����");
	}
}
