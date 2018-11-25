package date181125;
/*2.  do~while을 사용하여 아래의 형태의  
 *을 출력하는  static method를 작성하여 호출하세요.

 *
 **
 ***
 ****
*/
public class HWRevision181121_2 {

	public static void star() {
		
		int i = 0;
		do {
			
			int j = 0;
			do {
				System.out.print("*");
				j++;
			}while(j<=i);
			System.out.println();
			i++;
			
		}while(i<4);
	}
	
	public static void main(String[] args) {
		
		HWRevision181121_2.star();
	}
}
