package date181125;
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

public class HWRevision181119_2 {

	public static void main(String[] args) {
		
		String name = "young";
		String mean = "버스";
		int fare = 0;
		int extraFare = 0;
		int commuteDis = 24;
		
		if (!(mean.equals("도보") || mean.equals("지하철") || mean.equals("버스") || mean.equals("택시"))) {
			System.out.println("교통 수단은 도보, 지하철, 버스, 택시만 선택가능합니다.");
		} else {
			
			if (commuteDis > 10) {
				extraFare = ((commuteDis-10)/5)*100;
			}
			
			if (mean.equals("택시")){
				fare = 3800 + extraFare;
			} else if (mean.equals("버스")){
				fare = 1200 + extraFare;
			} else if (mean.equals("지하철")){
				fare = 1250 + extraFare;
			}
			
			System.out.printf("%s님 출퇴근 교통수단은 %s이며 거리는 %d키로 입니다.\n"
					+ "편도 이용 요금 %d원이고, 왕복이용 요금 %d원이며, 한달 20일 기준\n"
					+ "교통비는 총 : %d원 입니다.", name, mean, commuteDis, fare, fare*2, fare*20);
		}
	}
}
