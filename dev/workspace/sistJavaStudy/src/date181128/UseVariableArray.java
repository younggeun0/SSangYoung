package date181128;

public class UseVariableArray {

	public UseVariableArray() {
		int[][] arr = null;
		
		arr = new int[5][];
		
		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[4];
		// 가변 배열에서 기본형 형식으로 초기화 시 new int[]는 생략 불가!
		arr[3] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		arr[4] = new int[1];
		
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				System.out.printf("%4d", arr[i][j]);
//			}
//			System.out.println();
//		}
		
		for(int[] tmp : arr) {
			for(int val : tmp) {
				System.out.printf("%4d", val);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new UseVariableArray();
	}
}
