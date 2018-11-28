package date181128;

public class UseVariableArray2 {

	public UseVariableArray2() {

		int[][] arr = { { 1, 2 }, { 3, 4, 5, 6, 7 }, { 8, 9, 10 } };
		
		for(int[] tmp : arr) {
			for(int val : tmp) {
				System.out.printf("%4d", val);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new UseVariableArray2();
	}
}
