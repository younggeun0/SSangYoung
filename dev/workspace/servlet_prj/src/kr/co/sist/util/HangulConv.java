package kr.co.sist.util;

import java.io.UnsupportedEncodingException;

public class HangulConv {
	
	public static String toUTF(String kor) {
		// empty를 물어 볼 때 kor.equals("")하면 kor이 null일 경우 NullPointException이 발생
		// 따라서 이제 엠티를 비교할 땐 "".equals(kor)로 처리를 한다.
		try {
			if (kor != null || !"".equals(kor)) { // null이나 empty가 아니면 변환 
					kor = new String(kor.getBytes("8859_1"),"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return kor;
	}
	
	public static String toEUC(String kor) {
		try {
			if (kor != null || !"".equals(kor)) {
					kor = new String(kor.getBytes("8859_1"),"EUC-KR");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return kor;
	}
}
