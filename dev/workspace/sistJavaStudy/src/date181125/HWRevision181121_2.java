package date181125;
/*2.  do~while�� ����Ͽ� �Ʒ��� ������  
 *�� ����ϴ�  static method�� �ۼ��Ͽ� ȣ���ϼ���.

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
