package date181122;

import javax.print.attribute.standard.PrinterName;

public class VariableArguments02 {

	/**
	 * ���� �μ��� �ޱ����� �Ű������� ���� ���������� ����� �� �ִ�.
	 * @param i
	 * @param d
	 * @param j
	 */
	public void test2(int i, double d, int ... j) {
		System.out.println("ó�� �Ű����� : i = "+i);
		System.out.println("�ι�° �Ű����� : d = "+d);
		
		// �������ڴ� �迭�� �����Ǳ� ������ �ּҰ��� ����
		System.out.println("����° �Ű����� : j = "+j);
		
		for (int idx=0; idx<j.length; idx++) {
			System.out.println(j[idx]);
		}
	}
	
	// ���ڿ��� �Է¹��� �� �ִ� �Ű������� ���
	public void printName(String name) {
		System.out.println(name+"�� �ȳ��ϼ���.");
	}
	
	public static void main(String[] args) {
		
		VariableArguments02 va2 = new VariableArguments02();
		
		va2.test2(1, 3, 10,20,30,40,50);
		
		String name = "������";
		va2.printName(name);
	}
}
