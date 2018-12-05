package date181205;

/**
 * ��ü�� �������� �ʰ� ����ϴ� Ŭ����
 * @author owner
 */
public class UseMath {

	public UseMath() {

		/*int i=-12;
		System.out.println("i�� ���밪 : "+Math.abs(i));
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.round(10.5));
		System.out.println(Math.round(10.4));
		System.out.println(Math.floor(10.5));
		
		double d = Math.random();
		System.out.println("�߻��� ���� : "+d);
		System.out.println("������ ������ ���� : "+d*5);
		System.out.println("������ ������ �������� ���� : "+(int)(d*5));
		
		// A-Z �� �ϳ��� ���ڸ� ��ȯ�ϴ� ��. 65-90(�빮��), 97-122(�ҹ���)
		// ���ĺ��� 26��
		// ���� �빮�� ���
		for(int j=0; j<5; j++) {
			System.out.println((char)((int)(Math.random()*26)+65));
		}
		
		// ���� �ҹ��� ���
		for(int j=0; j<5; j++) {
			System.out.println((char)((int)(Math.random()*26)+97));
		}*/
	}
	
	// ���� ���ã��� ������� ��ȯ���ִ� �޼ҵ�
	// 48~57 ���� 65~90 �빮��, 97~122 �ҹ���
	// �����ڴ빮��,�ҹ���,���ڷ� �̷���� 
	// ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ� �� 
	
	// if���� �̿��� ���
	public char[] createPassword() {
		char[] tempPass = new char[8];
		
		int rNum=0;
		for(int i=0; i<tempPass.length; i++) {
			while(true) {
				rNum = (int)(Math.random()*122)+1;
				if ((rNum > 47 && rNum < 58) || (rNum > 64 && rNum <91)
						|| (rNum > 96 && rNum < 123)) {
					break;
				} 
			}
			tempPass[i] = (char)rNum; 
		}
		System.out.println(tempPass);
		return tempPass;
	}
	
	// ����� ���
	public char[] createPassword2() {
		char[] tempPass = new char[8];
		String flag=
			"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		for(int i=0; i<tempPass.length; i++) {
			tempPass[i] = flag.charAt((int)(Math.random()*flag.length()));
		}
		
		System.out.println(tempPass);
		return tempPass;
	}
	
	// switch�� ����� ���
	public char[] createPassword3() {
		char[] tempPass = new char[8];
		
		int flag = 0;
		
		for(int i=0; i<tempPass.length; i++) {
			flag = (int)(Math.random()*3)+1;
			
			switch(flag) {
			case 1: // ����
				tempPass[i] = (char)((int)(Math.random()*10)+48);
				break;
			case 2: // �빮��
				tempPass[i] = (char)((int)(Math.random()*26)+65);
				break;
			case 3: // �ҹ���
				tempPass[i] = (char)((int)(Math.random()*26)+97);				
				break;
			} 
		}
	
		System.out.println(tempPass);
		return tempPass;
	}
	
	public static void main(String[] args) {
		
//		new UseMath().createPassword();
//		new UseMath().createPassword2();
		new UseMath().createPassword3();
	}
}
