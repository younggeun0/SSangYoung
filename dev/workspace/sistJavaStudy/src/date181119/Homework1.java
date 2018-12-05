package date181119;
/* 숙제 
 1. 출퇴근 시간을 입력받아 아래의 조건으로 출력하세요.
 	출력 : 출퇴근 시간은 최대 2시간의 제한이 있으며 60분을 넘는 다면 "장거리"
	60분 이하라면 "단거리"를 출력하세요.
*/
public class Homework1 {
	
	public static void main(String[] args) {
		
		int toWork = Integer.parseInt(args[0]);
		int fromWork = Integer.parseInt(args[1]);
		
		int commuteTime = toWork + fromWork;
		
		if (commuteTime < 0 ) {
			System.out.println("출퇴근 하긴 하세요?..");
		} else if (commuteTime > 120) {
			System.out.println("너무 오래 걸립니다..퇴사하세요");
		} else if (commuteTime <= 60) {
			System.out.println("단거리");
		} else {
			System.out.println("장거리");
		}
	}

}
