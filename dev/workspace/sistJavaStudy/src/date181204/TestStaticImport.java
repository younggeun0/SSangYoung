package date181204;

import static java.lang.Integer.MAX_VALUE;
//���� �̸��� ����� �ϳ��� import
//import static java.lang.Byte.MAX_VALUE; 

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;
import static java.lang.System.out;
/**
 * static import<br>
 * �ٸ� Ŭ������ static ����(Constant)�� method�� ���� Ŭ������
 * �ִ� ��ó�� ����� ��<br> 
 * 
 * import static ��Ű����.Ŭ������.method��|������;
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
