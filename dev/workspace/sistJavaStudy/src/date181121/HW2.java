/*2.  do~while을 사용하여 아래의 형태의  
      *을 출력하는  static method를 작성하여 호출하세요.
     
      *
      **
      ***
      ****
*/

package date181121;

public class HW2 {
	
	public static void starTriangle() {
		
		int i=1;		
		do {
			int j=0;
			do {
				System.out.print("*");
				j++;
			} while(j<i);
			
			System.out.println();
			i++;
		}while(i<5);
	}

	public static void main(String[] args) {
		
		// static method므로 직접 호출
		HW2.starTriangle();
	}
}
