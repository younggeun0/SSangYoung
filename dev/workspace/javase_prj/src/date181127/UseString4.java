package date181127;

// �ñ��� ������ �ּҸ� n�� �Է¹޾� ��������� �ƴ����� 
// �Ǵ��Ͽ� ����ϴ� �޼ҵ带 ��������. 
public class UseString4 {

	public void checkAddr(String... sigungu) {
		
		for(String oneAddr : sigungu) {
			if (oneAddr.contains("����")) {
				System.out.println(oneAddr+"�� �����");
			} else {
				System.out.println(oneAddr+"�� ����ƴ�");
			}
		}
	}
	
	public static void main(String[] args) {
	
		UseString4 us = new UseString4();
		
		String[] addrs = {
			"����� ������",
			"����� ���ʵ�",
			"������ ���뱸",
			"�λ�� �ϴܱ�"
		};
		
		us.checkAddr(addrs);
		
	}
}
