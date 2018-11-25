package date181125;
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
public class HWRevision181122 {
	
	public void getName() {
		System.out.println("young");
	}
	
	public int getYearOfBirth(int age) {
		return 2018-age+1;
	}
	
	public int getUnicode(char c) {
		return (int)c;
	}
	
	public void printNumOrAlphabet(int n) {
		// 48~57 65~90 97~122
		if ((n > 47 && n < 58) || (n > 64 && n < 91) || (n > 96 && n < 123)) {
			System.out.println((char)n);
		} else {
			System.out.println("48~57, 65~90, 97~122 ���̰��� ���ڷ� ����մϴ�.");
		}
	}
	
	public void getAddr() {
		System.out.println("����~~");
	}
	
	public void printFriends(String... names) {
		int cnt = 0;
		
		for(String name : names) {
			System.out.print(name+" ");
			cnt++;
		}
		System.out.println("\nģ���� "+cnt+"�� �Դϴ�.");
	}
	
	
	public static void main(String[] args) {
		
		HWRevision181122 obj = new HWRevision181122();
		
		obj.getName();
		
		System.out.println(obj.getYearOfBirth(29));

		System.out.println(obj.getUnicode('a'));

		obj.printNumOrAlphabet(55);
		
		obj.getAddr();
		
		obj.printFriends("��","��","��","��");
	}
}
