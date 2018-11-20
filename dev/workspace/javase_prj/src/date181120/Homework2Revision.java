/*
* 2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이  출력하세요.
*       교통수단은 "버스,지하철,택시,도보"로 제한한다.
*       버스요금 1200원, 지하철 요금 1250원, 택시요금  3800원 입니다.
*    요금은 10키로 까지는 기본요금, 매 5키로 초과시 마다  100원씩 증가 합니다.
*
* 출력  : xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로  입니다.
*       편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며,  한달 20일기준
*       교통비는 총: xxxx원 입니다.
*       
*       switch 사용해서 구현해보기
*/
package date181120;

public class Homework2Revision {
	
	public static void main(String[] args) {
		
		String name = args[0];
		String mean = args[1];
		int distance = Integer.parseInt(args[2]);
		
		int fare = 0;
		int extraFare = 0;
		int farePerMonth = 0;
		
		if (distance >= 10) {
			extraFare = (int)((distance-10)/5)*100;
		}
		
		switch (mean) {
			case "버스" :
				fare = 1200 + extraFare;
				break;
			case "지하철":
				fare = 1250 + extraFare;
				break;
			case "택시":
				fare = 3800 + extraFare;
				break;
			case "도보":
				break;
			default :
				System.out.println(args[1]+"은(는) 교통수단이 아닙니다..");
		}
		
		farePerMonth = fare*20;
		
		System.out.println(name+"님 출퇴근 교통수단은 "+mean
				+"이며 거리는 "+distance+"km입니다. \n편도 이용 요금은"
				+fare+"원이고, 왕복이용 요금은 "+(fare*2)
				+"이며, \n한달 20일 기준 교통비는 총 "+farePerMonth+"원입니다.");
		
		
	}

}
