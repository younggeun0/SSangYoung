package date181128;

public class Use2DArray {
	
	public Use2DArray() {
		
		int[][] twoDArr = {
			{ 1, 2,}, 
			{ 3, 4 },	
			{ 5, 6 }	
		};
		
		for(int i=0; i<twoDArr.length; i++) {
			for(int j=0; j<twoDArr[i].length; j++) {
				System.out.printf(twoDArr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("-----향상된 for문 사용-----");
		for(int[] oneDArr : twoDArr) {
			for(int i : oneDArr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Use2DArray();
	}
}
