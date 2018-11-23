package date181123;

/**
 * 마카펜을 구현한 클래스를 사용하는 클래스<br>
 * 4. 객체 생성
 * 5. 생성된 객체 사용
 * @author owner
 */
public class UseMarker {

	/**
	 * 기본생성자를 사용하여 객체를 생성한 후 setter method를 
	 * 호출하여 값ㅇ르 설정한 후 사용<br>
	 * Maker m = new Maker();
	 * ms.setXxx(값);<br>
	 * 
	 * @param args 메인메소드인수
	 */
	public static void main(String[] args) {

		// 검은색 마카펜 1개 생성
		Marker black = new Marker();

		black.setColor("검은색");
		black.setCap(1);
		black.setBody(1);
		
		System.out.printf("생성된 마카펜 색[%s], 뚜껑[%d], 몸체[%d]"
				,black.getColor(), black.getCap(), black.getBody());
		
		System.out.println();
		// 생성된 객체의 사용
		System.out.println(black.write("안녕하세요"));
		
		System.out.println("==========================================");
		
		// 빨간색 마카펜 객체를 5개 생성 후 사용
		Marker red = new Marker();
		
		red.setColor("빨간색");
		red.setBody(5);
		red.setCap(5);
		
		System.out.printf("생성된 마카펜 색[%s], 뚜껑[%d], 몸체[%d]"
				,red.getColor(), red.getCap(), red.getBody());
		
		
		
	}
}
