package date181120;

/**
 * ������ ��� (flow chart �׸��� ����)
 * 2x1=2 3x1=3 4x1=4 ... 9x1=9
 * ...
 * 2x9=18...             9x9=81
 * @author owner
 */
public class HW1 {

	public static void main(String[] args) {
		
		System.out.println("������ ���");
		
		for(int i=1; i<10; i++) {
			
			for(int j=2; j<10; j++) {
				System.out.print(j+" * "+i+" = "+(j*i)+"\t");
			}
			System.out.println();
		}
	}
}
