package date181127;
/* 
숙제 1.
주민번호를 입력받아 처리하는 프로그램을 작성
각 작업은 method로 정의하고 호출하여 결과를 받아서 처리
1-1)
  생성자는 주민번호를 받아 instance변수에 할당
  1-2)부터 instance 변수의 값을 사용
1-2)
  주민번호의 길이를 체크하여 14자가 아니면 false를 반환
1-3)
  주민번호의 6번째 자리가 '-'아니면 false를 반환
1-4)
  주민번호의 유효성 검증을 하는 method작성하여 유효하면 true/false 반환
  - 각자리에 234567-892345 를 곱한 값을 더하여 11로 나눈 나머지 값을 얻고
    11에서 그 값을 빼고 10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true
1-5)
  생년월일을 반환하는 일. 예) 1988-11-11 
1-6)
  나이를 반환하는 일. 예) 31
1-7)
  성별을 반환. 예) 남|여
1-8)
  내국인/외국인 반환 
  - 1,2,3,4 : 내국인 (1,2 - 1900년대생, 3,4 - 2000년대생)
  - 5,6,7,8 : 외국인 (5,6 - 1900년대생, 7,8 - 2000년대생)
1-9) 
  띠를 반환 예)양띠
*/
public class ValidateSSN {

	String ssn;
	
	// 1-1 생성자는 주민번호를 받아 instance변수에 할당
	public ValidateSSN(String ssn) {
		this.ssn = ssn;
	}

	// 1-2 주민번호의 길이를 체크하여 14자가 아니면 false를 반환
	private boolean checkLength() {
		if (ssn.length() == 14)
			return true;
		else 
			return false;
	}
	
	// 1-3 주민번호의 6번째 자리가 '-'아니면 false를 반환
	private boolean checkHyphen() {
		if (ssn.charAt(6) == '-')
			return true;
		else 
			return false;
	}
	
	// 1-4
	private boolean validateSSN() {
		
		int checkNum = 0;
		
		int j = 2;
		// 앞6자리
		for(int i=0; i<6; i++) {
			checkNum += Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
		}
		// 뒤6자리
		for(int i=7; i<ssn.length()-1; i++) {
			checkNum += Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
			if (j > 9) j=2;
		}
		
		checkNum %= 11;
		checkNum = 11-checkNum;
		checkNum %= 10;
		
		if (Integer.parseInt(ssn.substring(13))==checkNum)
			return true;
		else
			return false;
	}
	
	// 1-5 생년월일을 반환하는 일. 예) 1988-11-11 
	private String getBirthDate() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthdate;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthdate = 19+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		} else {
			birthdate = 20+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		}
		
		return birthdate;
	}
	
	// 1-6 나이를 반환하는 일. 예) 31
	private int getAge() {
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthYear;
		int age;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthYear = 19+ssn.substring(0,2); 
			age = 2018-Integer.parseInt(birthYear)+1;
		} else {
			birthYear = 20+ssn.substring(0,2); 
			age = 2018-Integer.parseInt(birthYear)+1;
		}
		
		return age;
	}
	
	// 1-7 성별을 반환. 예) 남|여
	private char getGender() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		
		if (flag == 1 || flag == 3 || flag == 5 || flag == 7) {
			return '남';
		} else {
			return '여';
		}
	}
	
	// 1-8 내국인/외국인 반환 
	private String checkNation() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		
		if (flag == 0 || flag == 1 || flag == 2 || flag == 3 || flag == 4 || flag == 9) {
			return "내국인";
		} else {
			return "외국인";
		}
	}
	
	// 1-9 띠를 반환 
	// 태어난해를 입력받아 띠(12) 구하기
	// 11-양, 10-말, 9-뱀, 8-용, 7-토끼, 6-호랑이,  5-소, 4-쥐, 3-돼지,
	// 2-개, 1-닭, 0-원숭이
	private String getChineseZodiac() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthYear;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthYear = 19+ssn.substring(0,2); 
		} else {
			birthYear = 20+ssn.substring(0,2); 
		}
		
		int i = Integer.parseInt(birthYear);
		
		if (i%12 == 11) {
			return "양";
		} else if (i%12 == 10) {
			return "말";
		} else if (i%12 == 9) {
			return "뱀";
		} else if (i%12 == 8) {
			return "용";
		} else if (i%12 == 7) {
			return "토끼";
		} else if (i%12 == 6) {
			return "호랑이";
		} else if (i%12 == 5) {
			return "소";
		} else if (i%12 == 4) {
			return "쥐";
		} else if (i%12 == 3) {
			return "돼지";
		} else if (i%12 == 2) {
			return "개";
		} else if (i%12 == 1) {
			return "닭";
		} else {
			return "원숭이";
		}
	}
	
	public static void main(String[] args) {
		String ssn = "901206-2344599";
		//            01234567890123
		ValidateSSN vs = new ValidateSSN(ssn);
		
		if (vs.checkLength()) {
			if(vs.checkHyphen()) {
				if(vs.validateSSN()) {
					System.out.println("생년월일 : " + vs.getBirthDate());
					System.out.println("나이 : " + vs.getAge());
					System.out.println("성별 : " + vs.getGender());
					System.out.println("국적 : " + vs.checkNation());
					System.out.println("띠 : "+vs.getChineseZodiac());
				} else {
					System.out.println("검증이 안되는 주민번호입니다..");
				}
			} else {
				System.out.println("6번째 자리에 '-'이 없습니다..");
			}
		} else {
			System.out.println("주민번호 길이가 14자가 아닙니다..");
		}
	}
}
