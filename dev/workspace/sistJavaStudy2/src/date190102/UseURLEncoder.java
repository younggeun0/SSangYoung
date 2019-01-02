package date190102;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {
	public static void main(String[] args) {
		String msg = "abc������def123"; // MS949
		// ���̹� �˻� �� URL ���� query=abc%EA%B0%80%EB%82%98%EB%8B%A4def123
		try {
			// �Էµ� ���ڿ��� ������ ����ϴ� ������ �ڵ尪���� ����
			// MS949 -> ������ ����ϴ� UTF-8 ������ �ڵ尪���� ����
			String encodedMsg = URLEncoder.encode(msg, "UTF-8");
			System.out.println("���ڵ� : "+encodedMsg);
			
			String decodedMsg = URLDecoder.decode(encodedMsg, "UTF-8");
			System.out.println("���ڵ� : "+decodedMsg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
