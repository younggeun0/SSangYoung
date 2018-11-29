package date181129;

import java.util.Arrays;

public class UseSecureArray {

	public static void main(String[] args) {
		
		SecureArray sa = new SecureArray();
		int[] tempArr = sa.getArr();
		
		// 배열방의 값을 손쉽게 출력할려면 Arrays 클래스 사용
		System.out.println(Arrays.toString(tempArr));
		
		tempArr[0] = 190;
		System.out.println(Arrays.toString(tempArr));

		int[] tempArr1 = sa.getArr();
		System.out.println(Arrays.toString(tempArr1));
	}
}
