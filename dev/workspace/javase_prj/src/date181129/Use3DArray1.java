package date181129;

public class Use3DArray1 {

	public Use3DArray1() {
		int[][][] threeDArr = new int[][][]{
			{
				{1, 2, 3},
				{4, 5, 6}
			},
			{
				{7,8,9},
				{10,11,12}
			}
		};
		
		System.out.println("threeDArr�� ���Ǽ� : "+threeDArr.length
				+", ���� �� : "+threeDArr[0].length+", ���� �� : "
				+threeDArr[0][0].length);
		
		// �Ϲ� for��
		for(int i=0; i<threeDArr.length; i++) {
			for(int j=0; j<threeDArr[i].length; j++) {
				for(int k=0; k<threeDArr[i][j].length; k++) {
					System.out.print(threeDArr[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		// ���� for��
		for(int[][] twoDArr : threeDArr) {
			for(int[] oneDArr : twoDArr) {
				for(int val : oneDArr) {
					System.out.print(val+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Use3DArray1();
	}
}
