package date181120;

/**
 * ���� for
 * @author owner
 */
public class TestFor07 {

	public static void main(String[] args) {
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				System.out.println(i + " " + j);
			}
			System.out.println("---------------");
		}
		
		// ������ ���� ���
		for (int i=2; i<10; i++) { // ��
			
			System.out.println(i+"�� ����");
			
			for (int j=1;j<10;j++) {
				System.out.println(i+" * "+j+" = "+(i*j));
			}
			
			System.out.println(i+"�� ��");
		}
	}
}
