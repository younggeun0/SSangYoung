/*
 * 1.  while�� ����Ͽ� ������ ��ü ���� ����ϴ� 
 *     instance method���ۼ��ϰ�, ȣ���ϼ���.
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
		
		// instance method�̹Ƿ� ��ü ���� �� ȣ��
		HW1 hw1 = new HW1();
		hw1.gugudan();
	}
}
