package date181129.sub;

import date181129.TestSuper;

public class TestSub extends TestSuper{

	public static void main(String[] args) {
		
		TestSub ts = new TestSub();
		
		// �ڽİ� �θ� �ٸ� ��Ű���� �����ϸ�
		// �θ� ���� ������ method�� ���������ڰ�
		// public, protected�� �ڿ��� ��� ����
		// (ĸ��ȭ, Encapsulation)
		ts.public_i = 10;
		ts.protected_i = 20;
		
		System.out.println("�θ��� �ڿ� : "
				+ts.public_i+"/"+ts.protected_i);
	}
}
