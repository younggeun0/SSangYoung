package date181127;

/**
 * 문자열 저장소의 주소를 저장하고, 문자열을 다루는 기능을 제공하는
 * String class의 사용<br>
 * Java에서 제공하는 클래스의 이름과 내가만든 클래스의 이름이 같다면
 * 내가만든 클래스를 먼저 사용하게 된다.<br>
 * 자바에서 제공하는 클래스를 사용할 때 마다 "full path : 패키지명을
 * 기술하여 클래스를 사용하는 것"로 사용해야 한다.
 * 패키지명.클래스명
 * @author owner
 */
public class UseString2 {
	
	public static void main(String[] args) {
		// 기본형 형식 사용
		String str = "AbcdEfg";
		
		// 참조형 형식 사용
		String mail = new String("young@ssang.kr");

		System.out.println(str);
		System.out.println(mail);
		
		System.out.println(str+"의 길이 : "+str.length());
		System.out.println(mail+"의 길이 : "+mail.length());
		
		System.out.println(str+"을 모두 대문자 "+str.toUpperCase());
		System.out.println(str+"을 모두 소문자 "+str.toLowerCase());
		
		// "AbcdEfg"
		//  01234567
		// indeOf는 L->R 진행하며 가장 처음 찾아지는 문자열의 인덱스를 얻는다.
		System.out.println(str+"에서 'd'의 인덱스 "+str.indexOf("dEf"));
		System.out.println(str+"에서 'z'의 인덱스 "+str.indexOf("z")); // 없어서 -1
		
		System.out.println(mail+"에서 \"@\"의 인덱스 "+mail.indexOf("@"));
		
		str="AbcdEfAg";
		//   01234567
		System.out.println(str+"에서 'A'의 인덱스 "+str.indexOf("A"));
		
		// lastIndexOf는 R->L으로 진행하면서 가장 처음 찾아지는 문자열의 인덱스를 얻는다.
		System.out.println(str+" 문자열에서 뒤로부터 얻어지는 'A'의 인덱스 "+str.lastIndexOf("A"));
		
		// 특정 인덱스의 문자얻기
		System.out.println(str+"에서 2번째 인덱스에 해당하는 문자 "+str.charAt(2));
		
		// 자식문자열 자르기
		System.out.println(str+"에서 인덱스가 2~5번째에 해당하는 문자열 "+str.substring(2,6));
		
		// young@ssang.kr 메일 주소만 얻기
		// 012345
		System.out.println(mail+"에서 계정명만 얻기 "+mail.substring(0,mail.indexOf("@")));
		
		System.out.println(mail+"에서 도메인 주소만 얻기 "+mail.substring(mail.indexOf("@")+1,mail.length()));
		// substring은 오버로딩돼 있다.
		// substring은 시작인덱스만 넣으면 끝까지 잘라낸다.
		System.out.println(mail+"에서 도메인 주소만 얻기 "+mail.substring(mail.indexOf("@")+1));
		
		// 앞뒤공백 자르기
		// trim() 앞뒤공백만 제거가능
		str="   A BC   ";
		System.out.println("["+str+"]에서 앞뒤공백제거 "+str.trim());
		
		// 문자열붙이기
		str="ABCD";
		String str1 = str.concat("EFG");
		String str2 = str+"EFG";
		System.out.println(str1);
		System.out.println(str2);
		
		// 문자열이 완벽하게 같은지 비교
		str = "정택성";
		System.out.println(str+"은(는) "+(str.equals("이재찬")?"반장":"평민"));
		
		// 문자열이 이 문자열로 시작하는지
		str="피씨방"; 
		if(str.startsWith("씨방")) {
			System.out.println("욕은 사용하실 수 없습니다.");
		} else {
			System.out.println(str);
		}

		str="서울시 강남구";
		str1="수원시 팔달구";
		System.out.println(str+"은(는) "+(str.startsWith("서울")?"서울입니다.":"서울이아닙니다."));
		System.out.println(str1+"은(는) "+(str1.startsWith("서울")?"서울입니다.":"서울이아닙니다."));
		
		// 특정 문자열로 끝났는지 
		str="서울시 강남구 역삼동";
		str1="경기도 김포시 김포리";
		System.out.println(str+"은(는) "+(str.endsWith("동")?"도시":"시골"));
		System.out.println(str1+"은(는) "+(str1.endsWith("동")?"도시":"시골"));
		
		// 치환 : 문자열 내의 모든 문자열을 찾아 치환
		str="나 지금 피씨방인데 넌 어디니 씨 방새야";
		// 메소드를 연결해서 호출하는 것을 method chain이라 한다.
		System.out.println(str.replaceAll("씨", "*").replaceAll("방", "*")); // 메소드 체인
		
		str="   A B C   ";
		System.out.println(str.replaceAll(" ", ""));
		
		// int는 String으로 할당 될 수 없다.
		// 기본형 데이터형을 문자열로 변환
		int i = 27;
		str = String.valueOf(i);
		System.out.println(str);
		double d=11.27;
		System.out.println(d+"");
		System.out.println(String.valueOf(d));
		
		str="dd";
		System.out.println(str.isEmpty());
		
		// 객체를 생성을 하지 않았을 때 그 클래스가 제공하는 method를 사용할 수 없다.
		str = null;
		try {
			System.out.println(str.isEmpty());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
