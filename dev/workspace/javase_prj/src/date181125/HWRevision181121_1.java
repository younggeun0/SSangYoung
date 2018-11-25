package date181125;
/*
 * 1.  while을 사용하여 구구단 전체 단을 출력하는 
 *     instance method를작성하고, 호출하세요.
 */

public class HWRevision181121_1 {

	public void gugu() {
		
		for(int i=1; i<10; i++) {
			for(int dan=2; dan<10; dan++) {
				System.out.printf("%d * %d = %d \t",dan, i, dan*i);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		HWRevision181121_1 gu = new HWRevision181121_1();
		gu.gugu();
	}
	
	
}
