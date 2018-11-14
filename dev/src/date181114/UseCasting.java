/*
	��������ȯ (Casting)
	- ������ ���������� �Ͻ������� ��ȯ�Ͽ� ����ϴ� ��
*/

class UseCasting{

	public static void main(String[] args) {

		byte b1=10, b2=20;		// �ڵ�����ȯ
		
		// ������ ����� int�� �ڵ�����ȯ, error! 
		// byte result = b1+b2;	

		// ��������ȯ!
		// ���δ� +���� ������ �켱������ ����
		// ������ ������ ���� ����
		byte result = (byte)(b1+b2);

		System.out.println(b1 + " + " + b2 + " = " + result);

		double d = 11.14;
		float f = (float)d;

		System.out.println("double : " + d + ", float : " + f);

		// ����� ��밡��, literal ��ü�� �ٲ��� ����
		float f1 = (float)2018.11; 
		System.out.println("float : " + f1);

		// error!
		// ������� literal���� ũ�� casting�� �����ϱ� ���� error �߻�
		// long l = (long)2147483648;

		// int�� float�� byte ���� ���Ƶ� ���� ��� ���°� �޶� �Ҵ� �ȵ�
		// ���ս� �߻�(�Ǽ����� ���� ��� ����� �Ҵ�)
		int i = (int)f1;

		System.out.println("int : " + i + ", float : " + f1);
		
		char c = 'A';
		System.out.println(c + "�� unicode(ASCII code)�� " + (int)c);

		// ����(�⺻�� <-> ������) �ٸ��� ��������ȯ�� ���� �ʴ´�.
		// error!
		// String str = "11";	// String�� ������ ������Ÿ��
		// int i2 = (int)str;		// int�� �⺻�� ������Ÿ��

		// boolean���� boolean�� ������ ��ȯ����
		// error!
		// boolean b=true;
		// int i3=(int)b;

		boolean b = true;
		boolean b3 = (boolean)b; // �ǹ̾��� ��������ȯ..

		System.out.println("boolean : " + b3);

	}// main
}// class