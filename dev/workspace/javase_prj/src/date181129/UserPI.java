package date181129;

public class UserPI {

	public static void main(String[] args) {
		PersonalInfo[] pi = new PersonalInfo[7];
		int cntSeoul = 0;
		int sumOfAge = 0;
		int oldestAge = 0;
		String oldestName="";
		String oldestGender="";
		
		
		for (int i = 0; i < pi.length; i++) {
			pi[i] = new PersonalInfo();
		}

		// 1.
		pi[0].setAllInfo(1, "이재찬", "서울시 강남구 역삼동", 28, "남자");
		pi[1].setAllInfo(2, "이재현", "서울시 동대문구 답십리동", 27, "남자");
		pi[2].setAllInfo(3, "김정운", "수원시 영통구 영통동", 26, "남자");
		pi[3].setAllInfo(4, "정택성", "서울시 구로구 구로동", 27, "남자");
		pi[4].setAllInfo(5, "정택순", "서울시 동작구 상도동", 29, "여자");
		pi[5].setAllInfo(6, "김건하", "경기도 부천시 부천동", 26, "남자");
		pi[6].setAllInfo(7, "이재순", "서울시 광진구 광나루동", 27, "여자");

		/*
		 * // 기존 for문 for(int i=0; i<pi.length; i++) { PersonalInfo tmp = new
		 * PersonalInfo(); tmp = pi[i]; tmp.printPersonalInfo(); }
		 */

		// 향상된 for문
		for (PersonalInfo p : pi) {
			p.printPersonalInfo();
			sumOfAge += p.getAge();
			if(p.getAddress().contains("서울")) {
				cntSeoul++;
			}
			if(p.getAge() > oldestAge) {
				oldestAge = p.getAge();
				oldestName = p.getName();
				oldestGender = p.getGender();
			}
		}
		
		System.out.println("서울시 거주자 "+cntSeoul+"명");
		System.out.println("나이 합 "+sumOfAge+"살");
		System.out.printf("최고령자 \"%s(%s)\"\n",oldestName, oldestGender);
	}
}
