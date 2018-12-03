package date181202;

public class Main {

	public static void main(String[] args) {
		
		PersonalInfo[] pplList = new PersonalInfo[7];
		int seoulPpl = 0;
		int sumOfAge = 0;
		int oldestAge = 0;
		String oldestName = "";
		String oldestGender = "";
		
		for(int i=0; i<pplList.length; i++) {
			pplList[i] = new PersonalInfo();
		}
		
		pplList[0].setPI(1, "이재찬", "서울시 강남구 역삼동", 28, "남자");
		pplList[1].setPI(2, "이재현", "서울시 동대문구 답십리동", 27, "남자");
		pplList[2].setPI(3, "김정운", "수원시 영통구 영통동", 26, "남자");
		pplList[3].setPI(4, "정택성", "서울시 구로구 구로동", 27, "남자");
		pplList[4].setPI(5, "정택순", "서울시 동작구 상도동", 29, "여자");
		pplList[5].setPI(6, "김건하", "경기도 부천시 부천동", 26, "남자");
		pplList[6].setPI(7, "이재순", "서울시 광진구 광나루동", 27, "여자");
		
		for(PersonalInfo pi : pplList) {
			pi.printPI();
			if(pi.getAddress().contains("서울")) {
				seoulPpl++;
			}
			sumOfAge += pi.getAge();
			if(pi.getAge() > oldestAge) {
				oldestAge = pi.getAge();
				oldestName = pi.getName();
				oldestGender = pi.getGender();
			}
		}
		
		System.out.println("서울시 거주자 "+seoulPpl+"명");
		System.out.println("나이 합 "+sumOfAge+"살");
		System.out.printf("최고령자 \"%s(%s)\"\n", oldestName, oldestGender);
	}
}
