/*
숙제 
아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을
 설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.
- API주석은 어떤 형태의 method인지를 주석으로 기술할것.

1. 자신의 이름을 반환하는 method작성.
2. 나이를 입력받아 태어난 해를 반환하는  method 작성.
3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
    문자를  출력하는 일을 하는 method  작성
5. 호출하면 자신의 주소를 출력하는  method 작성.
6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.) 
*/
package date181122;
 
public class HW1 {

	/**
	 *  호출하면 자신의 이름을 반환하는 method
	 */
	public void getMyName() {
		System.out.println("오영근");
	}

	/**
	 * 나이를 입력받아 태어난 해를 반환
	 * 
	 * @param age 입력받는 나이
	 * @return 태어난 해
	 */
	public int getYearOfBirth(int age) {
		return 2018-age+1;
	}
	
	/**
	 * 문자를 입력받아 해당 문자의 unicode 값을 반환하는 method
	 * 
	 * @param c 입력받은 문자
	 * @return 문자의 unicode값
	 */
	public int getUnicodeNum(char c) {
		return (int)c;
	}
	
	/**
	 * 입력받은 숫자가 ASCII 영문자 범위에 있을 때 해당 문자 출력하는 method
	 * 
	 * @param num 입력받는 숫자
	 */
	public void printNumToChar(int num) {
		if ((num > 64 && num < 91) || (num>96 && num<123))
			System.out.println((char)num);
		else 
			System.out.println("소문자는 65~90, 대문자는 97~122");
	}
	
	/**
	 *  호출하면 자신의 주소를 출력하는 method
	 */
	public void getMyAddress() {
		System.out.println("서울 ~구 ~동 ~로");
	}
	
	
	/**
	 * 친구들의 이름을 입력받아 출력하는 method
	 * 
	 * @param names 친구들의 이름들
	 */
	public void printMyFrinedsName(String... names) {
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		HW1 hw1 = new HW1();
		
		
		// 1.
		hw1.getMyName();
		
		// 2.
		System.out.println(hw1.getYearOfBirth(29));
		
		// 3.
		System.out.println(hw1.getUnicodeNum('A'));
		System.out.println(hw1.getUnicodeNum('Z'));
		System.out.println(hw1.getUnicodeNum('a'));
		System.out.println(hw1.getUnicodeNum('z'));
		
		// 4.
		hw1.printNumToChar(50);
		hw1.printNumToChar(65);
		hw1.printNumToChar(90);
		hw1.printNumToChar(97);
		hw1.printNumToChar(122);
		hw1.printNumToChar(123);

		
		// 5.
		hw1.getMyAddress();
		
		// 6.
		hw1.printMyFrinedsName("친구1","친구2","친구3","친구4","친구5");
	}
}
