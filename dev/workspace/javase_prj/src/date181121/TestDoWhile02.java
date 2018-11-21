package date181121;

public class TestDoWhile02 {

	public static void main(String[] args) {

		// 입력되는 단으로 구구단 출력
		int input = Integer.parseInt(args[0]);

		if (input > 1 && input < 10) { // 2단~9단 사이
			int j = 1;
			do {
				System.out.println(input+" * "+j+" = "+input*j);
				j++;
			} while (j < 10);
		} else {
			System.out.println("단은 2단에서 9단까지 입력해주세요");
		} 
	}
}
