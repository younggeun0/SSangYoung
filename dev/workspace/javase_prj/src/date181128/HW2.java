package date181128;
// ���� 2)
/* 2���� �迭�� ������ �������� ����� �Ʒ��� ���� ���� �־� ����ϴ� method �ۼ� 
 *  1 1 1 1 1 1 1 1 1
 *  1 0 0 0 0 0 0 0 1
 *  1 0 0 0 0 0 0 0 1
 *  1 0 0 0 0 0 0 0 1
 *  1 0 0 0 0 0 0 0 1
 *  1 1 1 1 1 1 1 1 1
 */
public class HW2 {

	int[][] arr = new int[6][9];
	
	public void setArr() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==0 || i==5 || j == 0 || j ==8)
					arr[i][j] = 1;
			}
		}
	}
	
	public void printArr() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%3d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		HW2 hw2 = new HW2();
		
		hw2.setArr();
		hw2.printArr();
	}
}
