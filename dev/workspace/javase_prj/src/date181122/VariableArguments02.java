package date181122;

import javax.print.attribute.standard.PrinterName;

public class VariableArguments02 {

	/**
	 * 가변 인수를 받기위한 매개변수는 가장 마지막에만 사용할 수 있다.
	 * @param i
	 * @param d
	 * @param j
	 */
	public void test2(int i, double d, int ... j) {
		System.out.println("처음 매개변수 : i = "+i);
		System.out.println("두번째 매개변수 : d = "+d);
		
		// 가변인자는 배열로 생성되기 때문에 주소값이 찍힘
		System.out.println("세번째 매개변수 : j = "+j);
		
		for (int idx=0; idx<j.length; idx++) {
			System.out.println(j[idx]);
		}
	}
	
	// 문자열을 입력받을 수 있는 매개변수를 사용
	public void printName(String name) {
		System.out.println(name+"님 안녕하세요.");
	}
	
	public static void main(String[] args) {
		
		VariableArguments02 va2 = new VariableArguments02();
		
		va2.test2(1, 3, 10,20,30,40,50);
		
		String name = "이재찬";
		va2.printName(name);
	}
}
