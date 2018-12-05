package date181121;

/**
 * static ���� (class ����)
 *  - Ŭ������ ����Ǹ� ���� ó�� �޸�(method)�� �ö󰡰�,
 *    ��� ��ü�� �ϳ��� ������ �����Ͽ� ����ϴ� ����
 * @author owner
 */
public class UseStaticVariable {

	static int i; // static ���� 	-> �ٷ� ���
	int j;		  // instance ����	-> ��üȭ �� ���
	
	public void test() {
		i = 100;
		j = 200;
		System.out.println(i+" / "+j);
	}

	public static void main(String[] args) {
	
		// class ������ ���. Ŭ������.������
		UseStaticVariable.i = 2000;
		
		System.out.println(UseStaticVariable.i);
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		
		usv.j = 5000;		// instance ������ ������ ��ü�� ���� ���
		usv1.j = 10000;		
		
		// usv.i = 300; 
		// ��ü������ ����ϸ� Ư�� ��ü�� ���� member������ �ƴϹǷ�
		// ����� ���������� �����ϴ� ������ �ƴϴ�. 
		UseStaticVariable.i = 10;
		
		System.out.println("usv��ü �ν��Ͻ����� : "+usv.j
				+", ����ƽ���� :"+UseStaticVariable.i);
		System.out.println("usv1��ü �ν��Ͻ����� : "+usv1.j
				+", ����ƽ���� :"+UseStaticVariable.i);
	}
}
