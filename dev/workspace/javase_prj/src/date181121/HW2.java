/*2.  do~while�� ����Ͽ� �Ʒ��� ������  
      *�� ����ϴ�  static method�� �ۼ��Ͽ� ȣ���ϼ���.
     
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
		
		// static method�Ƿ� ���� ȣ��
		HW2.starTriangle();
	}
}
