/*
 * 1.  while�� ����Ͽ� ������ ��ü ���� ����ϴ� 
 *     instance method���ۼ��ϰ�, ȣ���ϼ���.
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
		
		// instance method�̹Ƿ� ��ü ���� �� ȣ��
		HW1 hw1 = new HW1();
		hw1.gugudan();
	}
}
