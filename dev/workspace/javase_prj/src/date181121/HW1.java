/*
 * 1.  while을 사용하여 구구단 전체 단을 출력하는 
 *     instance method를작성하고, 호출하세요.
 */
package date181121;
public class HW1 {

	public void gugudan() {
		
		for(int i=1; i<10; i++) {
			
			for (int j=2; j<10; j++) {
				System.out.print(j+" * "+i+" = "+(j*i)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		// instance method이므로 객체 생성 후 호출
		HW1 hw1 = new HW1();
		hw1.gugudan();
	}
}
