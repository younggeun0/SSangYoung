package kr.co.sist.service;

import java.util.Calendar;

public class CookieService {

	// DB를 사용하지 않는 Service 메소드들
	public String nameMsg(String name) {
		return "<marquee>"+name+"님 안녕하세요!</marquee>";
	}
	public int birth(int age) {
		Calendar cal = Calendar.getInstance();
		
		return cal.get(Calendar.YEAR)-age+1;
	}
}
