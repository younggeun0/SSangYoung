package date181127;

/**
 * 1���� �迭 : ���ϳ��� ���θ� ������ �迭<br>
 * �迭 - �޸𸮿� ���ϵ����������� ������ ��������<br>
 * ������ ��������, ����������<br>
 * �ϰ�ó���� �� ���<br>
 * ���� ���� ��� (�迭��.length)
 */
public class UseArray1 {
	
	/**
	 *  1���� �迭�� ������ �������� ���
	 */
	public UseArray1() {
		// 1.�迭 ����) ��������[] �迭�� = null;
		int[] arr = null;
		
		// 2.�迭 ����) �迭�� = new ��������[���ǰ���];
		arr = new int[6];
		System.out.println(arr);
		// �迭�� �����ϸ� ��� ���� ���� �ʱ�ȭ�� �ȴ�.
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		// ����� ������ ���ÿ�
		int[] arr1 = new int[8];
		System.out.println(arr1);

		System.out.println("arr�迭 ���� ���� "+arr.length
				+", arr1�迭 ���� ���� "+arr1.length);
		
		// 3.�� �Ҵ�) �迭��[�����ε���] = ��;
		arr[0] = 11;
		arr[1] = 27;
		arr[2] = 14;
		arr[3] = 46;
		
		// 4.�� ��� (�ϰ�ó��)
		for(int i : arr) {
			System.out.print(i+" ");
		}
		for(int i=0; i<arr.length;i++) {
			System.out.println("arr["+i+"]="+arr[i]);
			System.out.printf("arr[%d]=%d \n",i,arr[i]);
		}
		System.out.println();
		// �迭�� ���� �ε����� ����ϸ� error(ArrayIndexOutOfBoundsException)
		// System.out.println(arr[7]);
	}
	
	public static void main(String[] args) {
		new UseArray1();
	}
}
