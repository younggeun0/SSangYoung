package date181205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar : 단일 날짜 정보를 얻을 때.<br>
 * 
 * @author owner
 */
public class UseCalendar {
	
	public UseCalendar() {
		// Calendar 클래스의 인스턴스 얻기
		// 1. getInstance사용
		Calendar cal = Calendar.getInstance();
		
		// 2. is-a 관계
		Calendar cal1 = new GregorianCalendar();
		
		// 3. 자식만으로 객체 생성
		GregorianCalendar gc = new GregorianCalendar();
		
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);
		
		// Constant를 넣으면 가독성이 향상된다.
		int year = cal.get(Calendar.YEAR);
		
		System.out.println(year);
		
	}
	

	public static void main(String[] args) {
	
		new UseCalendar();
	}
}
