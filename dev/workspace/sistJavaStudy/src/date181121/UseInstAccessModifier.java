package date181121;

/**
 * ���� ��Ű���� �����ϴ� �ٸ� Ŭ������ �ν��Ͻ����� ���� ���
 * ���������ڰ� public protected, default�� �͸� ��밡��
 * @author owner
 */
public class UseInstAccessModifier {

	public static void main(String[] args) {
		
		InstAccessModifier ivam = new InstAccessModifier();
		
		System.out.println("public : "+ ivam.pub_i);
		System.out.println("protected : "+ ivam.pro_i);
		System.out.println("default : "+ ivam.def_i);
//		System.out.println("private : " + ivam.pri_i); ���Ұ�
	}
}
