package date181122;

/**
 * 특수문자 : 문자열 내 \로 시작하는 기능을 가진 문자
 * 
 * @author owner
 */
public class EscapeCharacter {

	public static void main(String[] args) {
		// \t : tab
		System.out.println("이\t재현");
		System.out.println("이\t\t재현");

		// \n : new line
		System.out.println("정\n택성");

		// \r : carriage return 원래 커서만 앞으로 이동인데 줄이 바뀜
		// \r\n : 윈도우 줄바꿈
		System.out.println("오\r영근");

		// \" : print "
		System.out.println("오늘은 \"급여일\" 입니다.");
		// \' : print '
		System.out.println("오늘은 \'급여일\' 입니다.");
		// \\ : print \
		System.out.println("c:\\users\\owner\\youngRepositories\\SSangYoung\\...");
	}
}
