package date181202;
/* 2���� �迭�� ������ �������� ����� �Ʒ��� ���� ���� �־�  ����ϴ� method �ۼ�
*  1 1 1 1 1 1 1 1 1
*  1 0 0 0 0 0 0 0 1
*  1 0 0 0 0 0 0 0 1
*  1 0 0 0 0 0 0 0 1
*  1 0 0 0 0 0 0 0 1
*  1 1 1 1 1 1 1 1 1
*/
public class HWRevision02 {

	public static void main(String[] args) {
		// 6�� 9��
		
		int[][] arr = new int[6][9];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = (i==0 || i==arr.length-1 ||
						j==0 || j == arr[i].length-1) ? 1 : 0;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
