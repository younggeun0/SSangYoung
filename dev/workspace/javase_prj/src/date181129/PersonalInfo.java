/*
숙제 1.
번호,이름,주소,나이,성별을  저장할 수 있는 클래스를 만들고 
아래와 같은 값을 입력합니다.

입력값
1, 이재찬, 서울시 강남구 역삼동, 28,남자
2, 이재현, 서울시 동대문구 답십리동, 27,남자
3, 김정운, 수원시 영통구 영통동, 26,남자
4, 정택성, 서울시 구로구 구로동,27, 남자
5, 정택순, 서울시 동작구 상도동,29,여자
6, 김건하, 경기도 부천시 부천동,26,남자
7, 이재순, 서울시 광진구 광나루동,27,여자
 서울시 거주자 x명
 나이 합 x살
 최고령자 "정택순(여자)"
 
1. 위의값을 배열에 입력하는 method를 작성할것.
2. 배열에 입력된 값을 출력하는 method 를 작성할것.
   2번 method 에서 서울시에 살고 있는 인원수를 출력 할것.
   2번 method 에서 나이의 합을 출력 할것.
   2번 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것.
 */
package date181129;

public class PersonalInfo {
	private int num;
	private String name;
	private String address;
	private int age;
	private String gender;
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}

	// 1. 배열에 입력하는 method를 작성할것.
	public void setAllInfo(int num, String name, String address, int age, String gender) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
	}
	
	// 2.
	public void printPersonalInfo() {
		System.out.printf("%d, %s, %s, %d, %s\n",
				getNum(), getName(), 
				getAddress(), getAge(),
				getGender());
	}
}
