package date181127;

// 시군구 형태의 주소를 n개 입력받아 서울시인지 아닌지를 
// 판단하여 출력하는 메소드를 만들어보세요. 
public class UseString4 {

	public void checkAddr(String... sigungu) {
		
		for(String oneAddr : sigungu) {
			if (oneAddr.contains("서울")) {
				System.out.println(oneAddr+"은 서울시");
			} else {
				System.out.println(oneAddr+"은 서울아님");
			}
		}
	}
	
	public static void main(String[] args) {
	
		UseString4 us = new UseString4();
		
		String[] addrs = {
			"서울시 논현동",
			"서울시 서초동",
			"수원시 영통구",
			"부산시 하단구"
		};
		
		us.checkAddr(addrs);
		
	}
}
