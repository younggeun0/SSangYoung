package date181121.sub;

import date181121.InstAccessModifier;

/**
 * ��Ӱ��迡 �ִٸ� �ڽ�Ŭ������ �����Ͽ� �θ�Ŭ���� ���ٰ���
 * ���������� public, protected�� ��밡��
 * @author owner
 */
public class UseInstAccessModifier2 extends InstAccessModifier  {

	public static void main(String[] args) {
		
		UseInstAccessModifier2 ivam = new UseInstAccessModifier2();
		
		System.out.println("public : "+ ivam.pub_i);
		System.out.println("protected : "+ ivam.pro_i);
//		System.out.println("default : "+ ivam.def_i); ���Ұ�
//		System.out.println("private : " + ivam.pri_i); ���Ұ�
	}
}
