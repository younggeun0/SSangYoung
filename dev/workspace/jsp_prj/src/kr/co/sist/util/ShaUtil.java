package kr.co.sist.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class ShaUtil {
	
	public static String shaEncoding(String plainText) {
		String cipherText = "";
		Base64 base64 = new Base64();
		
		if (plainText != null || !"".equals(plainText)) {
			try {
				// 1. �˰����� ����� �� �ִ� ��ü�� ��´�.
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				
				// 2. ��(Plain Text)�� ��ȣ��(Cipher Text)�� ��ȯ 
				md.update(plainText.getBytes());
				
				// 3. ��ȯ�� ��ȣ�� (Cipher Text) ���
				cipherText = new String(base64.encode(md.digest()));
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return cipherText;
	}
}
