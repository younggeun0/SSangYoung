package date181125;

/*
 *  0 0
 *   1 0 1 1
 *    2 0 2 1 2 2
 *     3 0 3 1 3 2 3 3
 *  show the same on console
 */
public class HWRevision181120_2 {

	public static void main(String[] args) {
		
		for(int i=0; i<4; i++) {
			
			for(int k=0; k<i; k++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<=i; j++) {
				System.out.printf("%d %d ",i,j);
			}
			System.out.println();
		}
	}
}
