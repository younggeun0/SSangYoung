package date181205;

import java.util.StringTokenizer;

public class UseStringTokenizer {

	public UseStringTokenizer() {
		String msg = "������ ������ �Դϴ�. ������ -5�Դϴ�.";
		
		// �������� ���� : �Ű����� �ϳ��� ������ ���
		StringTokenizer stk = new StringTokenizer(msg);
		
		System.out.println(stk.countTokens()+"��");
		
		while(stk.hasMoreTokens()) { // ��ū�� �����ϴ���?
			// ��ū�� ��� �����͸� �������� �̵���Ŵ
			System.out.println(stk.nextToken());
		}
		
		String names = "������,������~���ü�,����ö.������~������,������";
		
		// Ư�����ڷ� ��ū�� ����
		// ','�� ����
		StringTokenizer stk1 = new StringTokenizer(names, ",");
		System.out.println("��ū�� �� : "+stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		
		// '~'�� ����
		StringTokenizer stk2 = new StringTokenizer(names, "~");
		System.out.println("��ū�� �� : "+stk2.countTokens());
		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
		
		// '.'�� ����
		StringTokenizer stk3 = new StringTokenizer(names, ".");
		System.out.println("��ū�� �� : "+stk3.countTokens());
		while(stk3.hasMoreTokens()) {
			System.out.println(stk3.nextToken());
		}
		
		// ',~.'�� ����
		StringTokenizer stk4 = new StringTokenizer(names, ",~.");
		System.out.println("��ū�� �� : "+stk4.countTokens());
		while(stk4.hasMoreTokens()) {
			System.out.println(stk4.nextToken());
		}
		
		// Ư�����ڷ� ��ū ����, ���е� ���ڿ��� ��ū���� ���
		// �Ű����� 3��¥�� 
		StringTokenizer stk5 = new StringTokenizer(names, ",~.", true);
		System.out.println("��ū�� �� : "+stk5.countTokens());
		while(stk5.hasMoreTokens()) {
			System.out.println(stk5.nextToken());
		}
	}
	
	public static void main(String[] args) {
		
		new UseStringTokenizer();
	}
}










