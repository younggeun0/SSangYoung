/*
���� 
�Ʒ��� ������ ó���ϴ� method�� type�� �˸°� �ۼ��ϰ� API�ּ���
 ������ �� ȣ���Ͽ� ����� �� �� Java Doc�� �����غ�����.
- API�ּ��� � ������ method������ �ּ����� ����Ұ�.

1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.
2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�.
3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.
4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������
    ���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ�
5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.
6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�(ģ���� n�� �Դϴ�.) 
*/
package date181122;
 
public class HW1 {

	/**
	 *  ȣ���ϸ� �ڽ��� �̸��� ��ȯ�ϴ� method
	 */
	public void getMyName() {
		System.out.println("������");
	}

	/**
	 * ���̸� �Է¹޾� �¾ �ظ� ��ȯ
	 * 
	 * @param age �Է¹޴� ����
	 * @return �¾ ��
	 */
	public int getYearOfBirth(int age) {
		return 2018-age+1;
	}
	
	/**
	 * ���ڸ� �Է¹޾� �ش� ������ unicode ���� ��ȯ�ϴ� method
	 * 
	 * @param c �Է¹��� ����
	 * @return ������ unicode��
	 */
	public int getUnicodeNum(char c) {
		return (int)c;
	}
	
	/**
	 * �Է¹��� ���ڰ� ASCII ������ ������ ���� �� �ش� ���� ����ϴ� method
	 * 
	 * @param num �Է¹޴� ����
	 */
	public void printNumToChar(int num) {
		if ((num > 64 && num < 91) || (num>96 && num<123))
			System.out.println((char)num);
		else 
			System.out.println("�ҹ��ڴ� 65~90, �빮�ڴ� 97~122");
	}
	
	/**
	 *  ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ� method
	 */
	public void getMyAddress() {
		System.out.println("���� ~�� ~�� ~��");
	}
	
	
	/**
	 * ģ������ �̸��� �Է¹޾� ����ϴ� method
	 * 
	 * @param names ģ������ �̸���
	 */
	public void printMyFrinedsName(String... names) {
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		HW1 hw1 = new HW1();
		
		
		// 1.
		hw1.getMyName();
		
		// 2.
		System.out.println(hw1.getYearOfBirth(29));
		
		// 3.
		System.out.println(hw1.getUnicodeNum('A'));
		System.out.println(hw1.getUnicodeNum('Z'));
		System.out.println(hw1.getUnicodeNum('a'));
		System.out.println(hw1.getUnicodeNum('z'));
		
		// 4.
		hw1.printNumToChar(50);
		hw1.printNumToChar(65);
		hw1.printNumToChar(90);
		hw1.printNumToChar(97);
		hw1.printNumToChar(122);
		hw1.printNumToChar(123);

		
		// 5.
		hw1.getMyAddress();
		
		// 6.
		hw1.printMyFrinedsName("ģ��1","ģ��2","ģ��3","ģ��4","ģ��5");
	}
}
