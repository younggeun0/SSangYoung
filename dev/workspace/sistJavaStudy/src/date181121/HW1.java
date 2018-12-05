/*
 * 1.  while을 사용하여 구구단 전체 단을 출력하는 
 *     instance method를작성하고, 호출하세요.
 */
package date181121;
public class HW1 {

	public void gugudan() {
		
		int i = 1;
		while(i<10) {
			
			int j = 2;
			while(j<10) {
				System.out.print(j+" * "+i+" = "+(j*i)+"\t");
				j++;
			}
			
			System.out.println();
			i++;
		}
	}
	
	public static void main(String[] args) {
		
		// instance method이므로 객체 생성 후 호출
		HW1 hw1 = new HW1();
		hw1.gugudan();
	}
}
