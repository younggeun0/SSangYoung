package date181209;
/*
숙제 1.
main method의 arguments로 날짜를 여러개 입력 받아 입력받은 날짜의
요일을 저장하고 출력하는 method 를 작성하세요.

예) java Test 4 12 30 32 35 15 4   

출력) 4 화
     12 수
     15 토
     30 일  
  
*/
public class RunDayCheck {

	public static void main(String[] args) {
		
		DayCheck dc = new DayCheck();
		dc.printDayAndDayOfWeek(dc.setDay(args));
	}
}
