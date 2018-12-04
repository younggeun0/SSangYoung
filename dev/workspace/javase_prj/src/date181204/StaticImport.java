package date181204;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class StaticImport {

	public static void main(String[] args) {

		int i = parseInt("20181204"); // 클래스명 필요없다.
		
		out.println(i);
	}
}
