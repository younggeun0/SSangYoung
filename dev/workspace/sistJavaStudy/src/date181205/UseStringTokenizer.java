package date181205;

import java.util.StringTokenizer;

public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "������ ������ �Դϴ�. ������ -5�Դϴ�.";
		
		// �������� ���� : �Ű����� �ϳ��� ������ ���
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"��");
		
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}
	}
	
	public static void main(String[] args) {
		
		new UseStringTokenizer();
	}
}
