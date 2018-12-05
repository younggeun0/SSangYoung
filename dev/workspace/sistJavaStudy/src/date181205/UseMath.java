package date181205;

/**
 * 객체를 생성하지 않고 사용하는 클래스
 * @author owner
 */
public class UseMath {

	public UseMath() {

		/*int i=-12;
		System.out.println("i의 절대값 : "+Math.abs(i));
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.round(10.5));
		System.out.println(Math.round(10.4));
		System.out.println(Math.floor(10.5));
		
		double d = Math.random();
		System.out.println("발생한 난수 : "+d);
		System.out.println("범위를 설정한 난수 : "+d*5);
		System.out.println("범위를 설정한 난수에서 정수 : "+(int)(d*5));
		
		// A-Z 중 하나의 문자를 반환하는 일. 65-90(대문자), 97-122(소문자)
		// 알파벳은 26개
		// 랜덤 대문자 출력
		for(int j=0; j<5; j++) {
			System.out.println((char)((int)(Math.random()*26)+65));
		}
		
		// 랜덤 소문자 출력
		for(int j=0; j<5; j++) {
			System.out.println((char)((int)(Math.random()*26)+97));
		}*/
	}
	
	// 계정 비번찾기시 새비번을 반환해주는 메소드
	// 48~57 숫자 65~90 대문자, 97~122 소문자
	// 영문자대문자,소문자,숫자로 이루어진 
	// 임의의 비밀번호 8자리를 생성하여 반환하는 일 
	
	// if문을 이용한 방식
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
	
	// 강사님 방식
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
	
	// switch문 사용한 방식
	public char[] createPassword3() {
		char[] tempPass = new char[8];
		
		int flag = 0;
		
		for(int i=0; i<tempPass.length; i++) {
			flag = (int)(Math.random()*3)+1;
			
			switch(flag) {
			case 1: // 숫자
				tempPass[i] = (char)((int)(Math.random()*10)+48);
				break;
			case 2: // 대문자
				tempPass[i] = (char)((int)(Math.random()*26)+65);
				break;
			case 3: // 소문자
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
