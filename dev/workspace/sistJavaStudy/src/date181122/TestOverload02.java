package date181122;

public class TestOverload02 {

	/**
	 * ������ �޼ҵ�� 3���� �⺻���� ���
	 */
	public void gugudan() {
		
		for(int i=1; i<10; i++) {
			System.out.println("3 * "+i+" = "+(3*i));
		}
	}
	
	/**
	 * �Է¹��� ���� ���� 2~9 ������ ��<br>
	 * �ش� �ܺ��� 9�ܱ��� ���
	 * @param dan �Է¹��� ���� ��
	 */
	public void gugudan(int dan) {
		
		if (dan>1 && dan<10) {
			System.out.println(dan+"���� ����մϴ�.");
			for(int i=dan; i<10; i++) {
				for(int j=1; j<10; j++) {
					System.out.println(i+" * "+j+" = "+(i*j));
				}
			}
		} else {
			System.out.println("2~9�� ���� �ܸ� ����մϴ�.");
		}
	}
	
	public static void main(String[] args) {
		
		TestOverload02 to2 = new TestOverload02();
		
		// ������ 3���� ����ϴ� method
		// to2.gugudan();
		
		// �Է��ϴ� ���� 2~9�� ������ �� 
		// �ش� �ܺ��� 9�ܱ��� ��� ����ϴ� method
		to2.gugudan(5);
		 
	}
}
