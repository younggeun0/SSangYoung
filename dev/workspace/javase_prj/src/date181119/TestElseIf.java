package date181119;

public class TestElseIf {

	public static void main(String[] args) {
		
		int i = Integer.parseInt(args[0]);
		
		System.out.println(i + "은(는) ");
		
		if (i < 0) {
			System.out.println("0보다 작아서 입력실패");
		} else if (i > 100) {
			System.out.println("100보다 커서 입력실패");
		} else {
			System.out.println("입력 성공");
		}
	}
}

