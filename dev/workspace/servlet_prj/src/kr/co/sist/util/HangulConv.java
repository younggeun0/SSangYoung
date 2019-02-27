package kr.co.sist.util;

import java.io.UnsupportedEncodingException;

public class HangulConv {
	
	public static String toUTF(String kor) {
		// empty�� ���� �� �� kor.equals("")�ϸ� kor�� null�� ��� NullPointException�� �߻�
		// ���� ���� ��Ƽ�� ���� �� "".equals(kor)�� ó���� �Ѵ�.
		try {
			if (kor != null || !"".equals(kor)) { // null�̳� empty�� �ƴϸ� ��ȯ 
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
