package date181127;

public class UseString3 {

	private boolean validEmail(String email) {
		
		boolean flag = false;
		
		if (email.length()>5 && email.indexOf("@")!=-1 
				&& email.indexOf(".")!=-1) {
			flag = true;
		}
			return flag;
		
		
		// 이렇게 리펙토링할 수 있다.
		/*return email.length()>5 && email.contains("@") 
				&& email.contains(".");*/
	}
	
	// 이메일을 입력받아 이메일의 유효성을 검증하여 boolean형으로 
	// 결과를 만들어 반환하는 일을 하는 메소드를 만들어 호출하여
	// 사용해보세요.
	public static void main(String[] args) {
	
		String email = "yg@mme.kr";
		UseString3 us = new UseString3();
		
		if (us.validEmail(email) == true) {
			System.out.println(email+"은 유효한 메일입니다.");
		} else {
			System.out.println(email+"은 유효하지 않은 메일입니다.");
		}
	}
}
