package date181206;

import java.text.DecimalFormat;

/**
 * DecimalFormat<br>
 * 숫자를 지정한 문자열로 변경
 * @author owner
 */
public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		int temp = 20181206;
		
		// 데이터가 없음 0을 채움
		DecimalFormat df = new DecimalFormat("0,000,000,000");
		// 데이터가 없으면 채우지 않음
		DecimalFormat df1 = new DecimalFormat("#,###,###,###");
		
		System.out.println("0사용 : "+df.format(temp)); // 0,020,181,206 
		System.out.println("#사용 : "+df1.format(temp)); // 20,181,206
		
		DecimalFormat df2 = new DecimalFormat("#,###.00");
		// 실수자릿수를 사용하면 마지막 뒷자리의 값이 
		// 반올림대상이라면 반올림한 결과를 보여준다.
		System.out.println("소수자리수 표현 : "+df2.format(201812.066)); // 201,812.07
	}
	
	public static void main(String[] args) {
		new UseDecimalFormat();
	}
}
