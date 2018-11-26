package date181126;

/**
 * 문자열에 대한 비교
 * 
 * @author owner
 */
public class TestString {

	public static void main(String[] args) {
	
		// 기본형 형식의 사용
		String str1 = "ABC"; 
		
		// 기본형 형식으로 선언한 문자열은 문자열 저장소의 주소를 저장하기 
		// 때문에 == 비교로 같은지 비교수행할 수 있다.
		if (str1 == "ABC") {
			System.out.println("기본형 == 같음");		
		} else {
			System.out.println("기본형 == 다름");
		}
		
		// 참조형 형식의 사용
		String str2 = new String("ABC");

		// 참조형 형식으로 사용하면 변수는 heap주소를 저장하고
		// heap에 만들어진 객체가 문자열 저장소의 주소를 저장한다.
		if (str2 == "ABC") {
			System.out.println("참조형 == 같음");		
		} else {
			System.out.println("참조형 == 다름");	
		}
		
		System.out.println("----------------------");
		
		if (str1.equals("ABC")) {
			System.out.println("기본형 equals 비교 같음.");
		} else {
			System.out.println("기본형 equals 비교 다름.");
		}
		
		if (str2.equals("ABC")) {
			System.out.println("참조형 equals 비교 같음.");
		} else {
			System.out.println("참조형 equals 비교 다름.");
		}
	}
}
