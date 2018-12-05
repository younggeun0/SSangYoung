package date181205;

/**
 * StringBuffer, StringBuilder(jdk 1.5)
 * 문자열을 heap에 직접 저장하고 사용하는 클래스
 * @author owner
 */
public class UseStringBuilder {
	
	public void useStringBuffer() {
		// 클래스 생성
		StringBuffer sb = new StringBuffer();

		// 값(정수, 실수, 문자, 문자열, 불린)을 추가하는 append method
		sb.append("오늘은 ");
		sb.append(12);
		sb.append("월 5일").append(" 수요일 입니다.");
		System.out.println(sb);

		// 값 삽입
		sb.insert(sb.indexOf(" "), " 2018년");
		System.out.println(sb);
		
		// 값 삭제
		sb.delete(sb.indexOf("2"), sb.indexOf("년")+1);
		System.out.println(sb);

		// 문자열 뒤집기
		sb.reverse();
		System.out.println(sb);

		// 다시 뒤집으면 정상으로 돌아옴
		sb.reverse();
		System.out.println(sb);
	}
	
	public void useStringBuilder() {
		StringBuilder sb = new StringBuilder();

		sb.append("오늘은 ");
		sb.append(12);
		sb.append("월 5일").append(" 수요일 입니다.");
		System.out.println(sb);

		sb.insert(sb.indexOf(" "), " 2018년");
		System.out.println(sb);
		
		sb.delete(sb.indexOf("2"), sb.indexOf("년")+1);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}
	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		
		System.out.println("StringBuffer와 StringBuilder의 사용법은 같다");
		System.out.println("--------------------------------");
		usb.useStringBuffer();
		System.out.println("--------------------------------");
		usb.useStringBuilder();
		
		
		
		String str = "안녕하세요."; // 짧은 문자열
		System.out.println(str);
		
		String str1 = "안";
		// 문자열에 '+'가 붙어서 긴 문자열이 된다.
		System.out.println(str1+"녕"+"하"+"세"+"요"+".");
		// new StringBuilder().append(str1).append("녕").append("하")...;
	}
}
