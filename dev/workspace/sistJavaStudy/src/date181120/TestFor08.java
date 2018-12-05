package date181120;

/**
 *	00
 *  1011
 *  202122
 *  30313233
 * @author owner
 */
public class TestFor08 {

	public static void main(String[] args) {
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(i+" "+j+" ");
			}
			System.out.println();
		}
	}
}
