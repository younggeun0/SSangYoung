package date181128;

/**
 * ��� ���� ������ 2���� �迭
 * @author owner
 */
public class Use2DArray2 {

	/**
	 * ������ �������� 2���� �迭 ���
	 */
	public void refType() {
		// 1.����) ��������[][] �迭�� = null;
		int[][] arr = null;
		
		// 2.����) �迭�� = new ��������[���Ǽ�][���Ǽ�];
		// ��� ���� ���� �ʱ�ȭ
		arr = new int[3][4];
		
		System.out.println(" arr�� ���� �� : "+arr.length
				+", ���� �� : "+arr[0].length);
		
		// 1+2) ��������[][] �迭�� = new ��������[���Ǽ�][���Ǽ�];
		int[][] arr1 = new int[4][5];
		
		System.out.println("arr1�� ���� �� : "+arr1.length
				+", ���� �� : "+arr1[0].length);
		
		// 3. �� �Ҵ�) �迭��[���ȣ][����ȣ] = ��;
		arr[0][0] = 10;
		arr[1][1] = 20;
		arr[2][2] = 30;
		
		// 4. �� ���) �迭��[���ȣ][����ȣ]
		System.out.printf("arr[0][0]=%d, arr[0][1]=%d, "
				+ "arr[0][2]=%d\n", arr[0][0], arr[0][1],
				arr[0][2]);
		
		// ��� ��� ���
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		
		// ���� for������ ���
		System.out.println("--------------------");
		// 2���� �迭�� ������ ������ �迭�� �̷�����ִ�.
		for(int[] tmpArr : arr) {
			// 1���� �迭�� ���� ���� ������������ �̷������.
			for(int i : tmpArr) {
				System.out.printf("%4d",i);
			}
			System.out.println();
		}
	}
	
	/**
	 * �⺻�� ������ ���
	 */
	public void priType() {
		// �౸�� ��ȣ�� ���� ���� ����.
		// ��������[][] �迭�� = { {��,..}, {��,.. }, ... };
		
		// 1. ����)
		int[][] arr = { 
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		
		System.out.println("�� : "+ arr.length
				+", �� : "+arr[0].length);
		
		// 2. ���Ҵ�)
		arr[0][0] = 100;
		
		// 3. �����)
		System.out.println(arr[0][0]);
		
		for(int i=0; i<arr.length; i++) { // ��
			for(int j=0; j<arr[i].length; j++) {	// ��
				System.out.printf("arr[%d][%d]=%-4d", i,j,arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// default constructor ������
		// - class�� ���������ڸ� ����
		Use2DArray2 ua2 = new Use2DArray2();
		
//		System.out.println("refType-------------");
//		ua2.refType();
//		System.out.println("--------------------");
		
		System.out.println("priType-------------");
		ua2.priType();
	}
}
