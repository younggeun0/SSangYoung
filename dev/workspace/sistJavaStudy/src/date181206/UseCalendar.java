package date181206;

import java.util.Calendar;
import java.util.GregorianCalendar;
public class UseCalendar {
	public UseCalendar() {
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = new GregorianCalendar();
		GregorianCalendar gc = new GregorianCalendar();
		
		int year = cal.get(Calendar.YEAR);
		// 월, java에서는 월의 시작이 0월
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		// 올해 몇번째 날인지
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		
		System.out.printf("%d-%d-%d 오늘은 올해의 %d번째 날\n",
				year,month,day,dayOfYear);

		// 요일 : 일(1), 월(2), 화(3), 수(4), 목(5), 금(6), 토(7)
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		/*switch(dayOfWeek) { // case 1~7, 가독성이 낮다
		case 1:	System.out.println("일요일");	break;
		case 2:	System.out.println("월요일");	break;
		case 3:	System.out.println("화요일");	break;
		case 4:	System.out.println("수요일");	break;
		case 5:	System.out.println("목요일");	break;
		case 6:	System.out.println("금요일");	break;
		case 7:	System.out.println("토요일");	break;
		}*/
		
		/*String week="";
		// 상수 사용하여 가독성 향상
		switch(dayOfWeek) { 
		case Calendar.SUNDAY:
			week="일요일";	break;
		case Calendar.MONDAY:
			week="월요일";	break;
		case Calendar.TUESDAY:
			week="화요일";	break;
		case Calendar.WEDNESDAY:
			week="수요일";	break;
		case Calendar.THURSDAY:
			week="목요일";	break;
		case Calendar.FRIDAY:
			week="금요일";	break;
		case Calendar.SATURDAY:
			week="토요일";	break;
		}
		System.out.printf("%d요일 %s\n",dayOfWeek, week);*/
		
		// 배열 활용하는 방식(권장)
		String[] weekTitle = { "일","월","화","수","목","금","토" };
		System.out.printf("%d요일 %s요일\n",dayOfWeek, 
				weekTitle[dayOfWeek-1]);
		
		// 오전(0) 오후(1)
		int amPm = cal.get(Calendar.AM_PM);
		
		// 상수 Calendar.AM, Calendar.PM을 이렇게 사용
		/*switch(amPm) {
		case Calendar.AM:
			System.out.println("오전");
			break;
		case Calendar.PM:
			System.out.println("오후");
			break;
		}*/
		
		// 배열로
		String[] arrAmPm = { "오전", "오후" };
		System.out.printf("%d %s\n",amPm, arrAmPm[amPm]);
	
		// 삼항연산자로
		System.out.printf("%s\n", amPm == Calendar.AM ? "오전" : "오후");
		
		// 시간
		int hour = cal.get(Calendar.HOUR);	// 12시간제
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24시간제
		System.out.printf("%d(%d)시\n", hour, hour24);
		
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d(%d):%d:%d\n",hour,hour24,minute,second);
		
		// Calendar는 생성된 시점의 날짜 정보를 가짐
		// 다른 날짜를 얻기 위해선 set을 사용
		System.out.println("-----------------------------------------------");
		System.out.printf("설정 전 %d-%d-%d %s요일\n",
			cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH)+1,
			cal1.get(Calendar.DAY_OF_MONTH),
			"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		// 년
		cal1.set(Calendar.YEAR, 2019);
		// 월 - 사람이 생각하는 월보다 1적게 설정
		cal1.set(Calendar.MONTH, 4);
		// 일 - 해당월의 존재하지 않는 일자가 설정되면 자동으로 다음달로 넘어가 설정됨
		cal1.set(Calendar.DAY_OF_MONTH, 32);
		
		System.out.printf("설정 후 %d-%d-%d %s요일\n",
				cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH)+1, 
				cal1.get(Calendar.DAY_OF_MONTH),
				"일,월,화,수,목,금,토".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println("-----------------------------------------------");
		
		// 이번달의 마지막 날을 알 수 있는 getActualMaximum
		System.out.println(cal1.getActualMaximum(Calendar.DATE));
		System.out.println(cal1.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
	public static void main(String[] args) {
		new UseCalendar();
	}
}
