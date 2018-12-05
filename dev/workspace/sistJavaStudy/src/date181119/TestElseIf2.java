package date181119;

public class TestElseIf2 {

	public static void main(String[] args) {
		//이름을 입력받아 "이재찬" 이면 반장을
		//이봉현 박영민 김정운 오영근 이면 "조장"을
		//그렇지 않으면 "평민"을 이름앞에 출력 하세요  
		
		if (args[0].equals("이재찬")) {
			System.out.print("반장 ");
		} else if (args[0].equals("이봉현") 
				|| args[0].equals("박영민")
				|| args[0].equals("김정운")
				|| args[0].equals("오영근")) {
			System.out.print("조장 ");
		} else {
			System.out.print("평민 ");
		}
		
		System.out.println(args[0] + "님 안녕하세요.");
	}
}
