/* 숙제 
1. 출퇴근 시간을 입력받아 아래의 조건으로 출력하세요.
	출력 : 출퇴근 시간은 최대 2시간의 제한이 있으며 60분을 넘는 다면 "장거리"
	60분 이하라면 "단거리"를 출력하세요.
 */
package date181125;
public class HWRevision181119_1 {

	public static void main(String[] args) {
	
		int commuteMin = 65;
		
		if (commuteMin > 120) {
			System.out.println("너무 출퇴근 시간이 깁니다.");
		} else if (commuteMin > 60) {
			System.out.println("장거리");
		} else {
			System.out.println("단거리");
		}
		
	}
}
