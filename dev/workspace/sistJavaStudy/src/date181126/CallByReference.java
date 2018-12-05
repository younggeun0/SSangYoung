package date181126;

/**
 * method�� �Ű������� ������������(class, ���ڿ�, array)�� ���
 * arguments�� ������ ������ �ϳ��� �ּҰ� �Ҵ�ȴ�.
 * (���� �����ϸ� ������ ��ü�� ���� ���� ����ȴ�.)
 * @author owner
 */
public class CallByReference {

	int i;
    int j;
	
	public void swap(CallByReference cbr) {
		int temp = 0;
		temp = cbr.i;
		cbr.i = cbr.j;
		cbr.j = temp;
		System.out.println("swap method�� i="+i+", j="+j);
	}
	
	public static void main(String[] args) {
		
		CallByReference cbr = new CallByReference();
		cbr.i = 12;
		cbr.j = 22;
		
		System.out.println("sawp �� �� i="+cbr.i+", j="+cbr.j);
		// �ּҰ� �״�� ����
		cbr.swap(cbr);
		
		System.out.println("sawp �� �� i="+cbr.i+", j="+cbr.j);
	}
}
