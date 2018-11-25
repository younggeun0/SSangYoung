package date181125;
/* 
* 2x1=2 3x1=3... 9x1=9
* ...
* 2x9=18 ....    9x9=81
*/
public class HWRevision181120_1 {

	public static void main(String[] args) {

		for (int i=1; i<10; i++) {
			for(int dan=2; dan<10; dan++) {
				System.out.printf("%d * %d = %d \t",dan,i,dan*i);
			}
			System.out.println();
		}
		
	}
}
