package date181125;
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
public class HWRevision181122 {
	
	public void getName() {
		System.out.println("young");
	}
	
	public int getYearOfBirth(int age) {
		return 2018-age+1;
	}
	
	public int getUnicode(char c) {
		return (int)c;
	}
	
	public void printNumOrAlphabet(int n) {
		// 48~57 65~90 97~122
		if ((n > 47 && n < 58) || (n > 64 && n < 91) || (n > 96 && n < 123)) {
			System.out.println((char)n);
		} else {
			System.out.println("48~57, 65~90, 97~122 사이값만 문자로 출력합니다.");
		}
	}
	
	public void getAddr() {
		System.out.println("서울~~");
	}
	
	public void printFriends(String... names) {
		int cnt = 0;
		
		for(String name : names) {
			System.out.print(name+" ");
			cnt++;
		}
		System.out.println("\n친구는 "+cnt+"명 입니다.");
	}
	
	
	public static void main(String[] args) {
		
		HWRevision181122 obj = new HWRevision181122();
		
		obj.getName();
		
		System.out.println(obj.getYearOfBirth(29));

		System.out.println(obj.getUnicode('a'));

		obj.printNumOrAlphabet(55);
		
		obj.getAddr();
		
		obj.printFriends("영","솔","리","박");
	}
}
