package date181127;

public class UseString3 {

	private boolean validEmail(String email) {
		
		boolean flag = false;
		
		if (email.length()>5 && email.indexOf("@")!=-1 
				&& email.indexOf(".")!=-1) {
			flag = true;
		}
			return flag;
		
		
		// �̷��� �����丵�� �� �ִ�.
		/*return email.length()>5 && email.contains("@") 
				&& email.contains(".");*/
	}
	
	// �̸����� �Է¹޾� �̸����� ��ȿ���� �����Ͽ� boolean������ 
	// ����� ����� ��ȯ�ϴ� ���� �ϴ� �޼ҵ带 ����� ȣ���Ͽ�
	// ����غ�����.
	public static void main(String[] args) {
	
		String email = "yg@mme.kr";
		UseString3 us = new UseString3();
		
		if (us.validEmail(email) == true) {
			System.out.println(email+"�� ��ȿ�� �����Դϴ�.");
		} else {
			System.out.println(email+"�� ��ȿ���� ���� �����Դϴ�.");
		}
	}
}
