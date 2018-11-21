package date181121;

/**
 * Instance Variable�� ����������(Access Modifier) ���
 * 	- public : Ŭ���� �ܺο��� ���� ����
 *  - protected : ���� ��Ű������ ���� ����
 *  		      ��Ű�� �ٸ��� ��Ӱ����� �ڽ� Ŭ������ ���� ����
 *  - private : Ŭ���� �ȿ����� ���� ����
 *  - default : ���� ��Ű������ ���� ����
 *  	        ��Ű���� �ٸ��� ���� �Ұ�
 * @author owner
 */
public class InstAccessModifier {

	public int pub_i;
	protected int pro_i;
	private int pri_i;
	int def_i;
	
	public static void main(String[] args) {
		
		// ��üȭ
		InstAccessModifier ivam = new InstAccessModifier();
		
		// ������ ������ �ִ� Ŭ���� �ȿ��� ��üȭ�� �Ǹ� ���������ڿ� 
		// ������� ��� ��밡��.
		System.out.println("public : " + ivam.pub_i);
		System.out.println("protected : " + ivam.pro_i);
		System.out.println("private : " + ivam.pri_i);
		System.out.println("default : " + ivam.def_i);
		
	}
}
