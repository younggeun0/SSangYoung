package date181204;

import static java.lang.Integer.MAX_VALUE;
//같은 이름의 상수는 하나만 import
//import static java.lang.Byte.MAX_VALUE; 

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
import static java.lang.System.out;
/**
 * static import<br>
 * 다른 클래스의 static 변수(Constant)나 method를 현재 클래스의
 * 있는 것처럼 사용할 때<br> 
 * 
 * import static 패키지명.클래스명.method명|변수명;
 * @author owner
 */
public class TestStaticImport {

	public static void main(String[] args) {
		out.println(MAX_VALUE);
		
		String year = "2018";
		String month = "12";
		String day = "4";
		
		int intYear = parseInt(year);
		int intMonth = parseInt(month);
		int intDay = parseInt(day);

		System.out.println(intYear+"/"+intMonth+"/"+intDay);
		System.out.println(toBinaryString(intYear)+"/"
				+toBinaryString(intMonth)+"/"
				+toBinaryString(intDay));
		
	}
}
