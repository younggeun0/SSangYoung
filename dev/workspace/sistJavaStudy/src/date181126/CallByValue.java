package date181126;

/**
 * method�� �Ű������� �⺻������ ���ǵȴٸ�
 * �Ű������� �Ҵ�Ǵ� ���� ����Ǿ� ���޵ȴ�.
 * �Ű������� ���� �����ϴ��� ������ ���� ������� �ʴ´�. 
 * => Call By Value
 * @author owner
 */
public class CallByValue {

	public void swap(int i, int j) {
		
		// �ԷµǴ� ������ ���� ���� ����.
		int temp = 0;
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap method called");
		System.out.println(i+" "+j);
	}
	
	public static void main(String[] args) {
		
		int i=11, j=26;
		System.out.println(i+" "+j);
		
		CallByValue cbv = new CallByValue();
		cbv.swap(i, j);
		
		System.out.println(i+" "+j);
	}
}
