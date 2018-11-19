package date181119;
/*
 * 2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이 출력하세요.
 * 	    교통수단은 "버스,지하철,택시,도보"로 제한한다.
 * 	    버스요금 1200원, 지하철 요금 1250원, 택시요금 3800원 입니다.
 *    요금은 10키로 까지는 기본요금, 매 5키로 초과시 마다 100원씩 증가 합니다.
 *
 * 출력  : xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로 입니다.
 *       편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며, 한달 20일기준
 *       교통비는 총: xxxx원 입니다.
 */

public class Homework2 {
	
	public static void main(String[] args) {
		
		String name = args[0];
		String means = args[1];
		int distance = Integer.parseInt(args[2]);
		int fare = 0;
		int extraFare = 0;
		int faresPerMonth = 0;
		
		if (!(args[1].equals("버스")||args[1].equals("지하철")
			|| args[1].equals("택시")|| args[1].equals("도보"))) {
			System.out.println("버스, 지하철, 택시, 도보만 교통수단이예요");
			System.exit(0);
		} else {
			if (distance >= 10) {
				extraFare = (int)((distance-10)/5)*100;
			}
			
			if (args[1].equals("버스")) {
				fare = 1200 + extraFare;
			} else if (args[1].equals("지하철")) {
				fare = 1250 + extraFare;
			} else if (args[1].equals("택시")) {
				fare = 3800 + extraFare;
			}
		}
		
		faresPerMonth = fare*40;
		
		System.out.println(name + "님 출퇴근 교통수단은 "
				+ means + "이며 거리는 " + distance
				+ "km 입니다. \n편도 이용 요금은 "
				+ fare + "원이고, 왕복이용 요금은 "
				+ (fare*2) + "원이며, \n한달 20일 기준 교통비는 총 "
				+ faresPerMonth + "원 입니다.");
		
	}
}
