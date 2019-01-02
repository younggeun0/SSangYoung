package date190102;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {
	public static void main(String[] args) {
		String msg = "abc가나다def123"; // MS949
		// 네이버 검색 시 URL 쿼리 query=abc%EA%B0%80%EB%82%98%EB%8B%A4def123
		try {
			// 입력된 문자열을 웹에서 사용하는 형태의 코드값으로 변경
			// MS949 -> 웹에서 사용하는 UTF-8 형식의 코드값으로 변경
			String encodedMsg = URLEncoder.encode(msg, "UTF-8");
			System.out.println("인코딩 : "+encodedMsg);
			
			String decodedMsg = URLDecoder.decode(encodedMsg, "UTF-8");
			System.out.println("디코딩 : "+decodedMsg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
