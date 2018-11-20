package date181120;

/**
 * 	0 1 0 2 0 3 0 4
 *  1 2 1 3 1 4 
 *  2 3 2 4 
 *  3 4
 *  출력하기
 */
public class TestFor09 {

	public static void main(String[] args) {
		
		for(int i=0;i<4; i++) {
			for (int j=i+1; j<5; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
	}
}
