package date181119;

public class TestIf2 {
	
	public static void main(String[] args) {
		
		// 이름을 입력받아 이름이 "이재찬"이면 이름을 출력하기 전
		// "반장"을 출력, 그렇지 않으면 이름만 출력
		
		if (args[0].equals("이재찬")) {
			System.out.print("반장 ");
		}
		
		System.out.println(args[0]);
		
		// 숫자형태의 문자열을 정수로 변환
		int i = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		int r = Integer.parseInt(args[3]);
		
		System.out.println(i+"+"+j+"+"+r+"="+(i+j+r));
		
	}

}
