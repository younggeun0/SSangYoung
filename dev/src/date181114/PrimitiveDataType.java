/*
	�⺻�� ��������(Primitive DataType)
	������ : byte, short, int, long
	�Ǽ��� : float, double
	������ : char
	���� : boolean
*/
class PrimitiveDataType {
	
	public static void main(String[] args) {
		// ������
		byte b = 10;
		short s = 20;
		int i = 30;
		// �Ҵ�Ǵ� ���� 4byte�� �̹Ƿ� literal�� ��ȯ�� �ʿ䰡 ����.
		long l = 40;
		
		b = -128; // byte : -128 ~ +127
		
		// ���� literal�� 4byte
		// �����Ϸ��� ���� 8byte�� �ʿ��� ���̹Ƿ� 
		// literal�� ũ�⸦ ����(�����), ������� �ڿ� l�̳� L�� ���δ�
		long l2 = 2147483648L;
		
		System.out.println("byte : " + b + ", short : " + s + ", int : " + i 
			+ ", long : " + l + ", long2 : " + l2);

		/*
		  0  - �������
		 '0' - ���ڻ��
		 "0" - ���ڿ����
		*/

		// ������ : unicode �� : \u0000
		// �Ҵ��� unicode�� ��
		// char c = 'A';
		// char c2 = '0';
		// char c3 = '��';

		// �����ڵ尪�� �ٷ� �Ҵ��ص� ���� ��� ���
		char c = 65;
		char c2 = 48;
		char c3 = 44032;

		// ����� unicode�� ���� ���ڰ� ��µ�
		System.out.println("char : " + c +", " + c2 + ", " + c3);

		// �Ǽ��� 
		// float���� 4byte, 3.14�� �Ǽ� ���ͷ��� 8byte
		// float���� 8byte �Ǽ� ���ͷ��� �������
		// f �Ǵ� F�� �Ǽ����ͷ� �ڿ� �ٿ� �����
		float f = 3.14F;

		// double�� literal�� datatype�� ũ�Ⱑ �����Ƿ�
		// ����ø� ������ �� �ִ�. (d, D)
		double d = 3.14;
		double d2 = 3.14D;

		System.out.println("float : " + f + ", double : "
			+ d + ", double2 : " + d2);

		// �Ҹ��� 
		boolean tu = true;
		boolean fa = false;

		// tu = 0; boolean�� true, false�� ���� �� �ִ�. 
		// có�� 1, 0�� ������� �ʴ´�.

		System.out.println("boolean : " + tu + ", boolean : " + fa);

		byte b1 = 10, b2 = 20, result = 0;
		
		// error �߻�
		result = b1 + b2; 

		System.out.println(result);
	}// main 
}// class
