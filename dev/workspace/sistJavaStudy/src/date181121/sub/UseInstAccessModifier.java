package date181121.sub;

import date181121.InstAccessModifier;

/**
 * �ٸ� ��Ű���� �����ϴ� Ŭ������ �ν��Ͻ����� ���� ���
 * ���������� public�� ��밡��
 * @author owner
 */
public class UseInstAccessModifier {

	public static void main(String[] args) {
		
		InstAccessModifier ivam = new InstAccessModifier();
		
		System.out.println("public : "+ ivam.pub_i);
//		System.out.println("protected : "+ ivam.pro_i); ���Ұ�
//		System.out.println("default : "+ ivam.def_i); ���Ұ�
//		System.out.println("private : " + ivam.pri_i); ���Ұ�
	}
}
