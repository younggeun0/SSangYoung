package date181123;

/**
 * 마카펜을 대상으로 선정하여 추상화를 진행하여 만들어진 클래스<br>
 * 마카펜의 명사적 특징 : 색, 몸체, 뚜껑 =&gt; 변수<br>
 *          동사적 특징 : 쓴다 =&gt; method<br>
 * 
 * class는 사용자정의 자료형, 참조형 데이터형이다.<br>
 * 
 * @author owner
 */
public class Marker {

	// 명사적 특징(변수)
	private String color;	// 마카펜의 색
	private int body;		// 마카펜의 몸체의 갯수
	private int cap;		// 마카펜의 뚜껑의 갯수

	
	// setter
	/**
	 * 생성된 마카펜 객체의 색을 설정하는 일을 함
	 * 검은색, 파란색, 빨간색만 설정. 그 외의 색은 검은색으로 처리
	 * 
	 * @param color 색
	 */
	public void setColor(String color) {
		// 인스턴스변수에 설정될 값에 대한 검증 수행
		if (color.equals("빨간색") || color.equals("파란색")) 
			this.color = color;
		else
			this.color = "검은색";
	}
	/**
	 * 생성된 마카펜 객체의 몸체의 갯수를 설정하는 일
	 * @param body 몸체의 갯수
	 */
	public void setBody(int body) {
		this.body = body;
	}
	/**
	 * 생성된 마카펜 객체의 뚜껑의 갯수를 성정하는 일
	 * @param cap 뚜껑의 갯수
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}
	
	// getter
	/**
	 * 설정된 마카펜 객체가 가지고 있는 색을 반환
	 * @return 색
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 설정된 마카펜 객체가 가지고 있는 몸체 수를 반환
	 * @return 몸체 수
	 */
	public int getBody() {
		return body;
	}
	/**
	 * 설정된 마카펜 객체가 가지고 있는 뚜껑 수를 반환
	 * @return 뚜껑 수
	 */
	public int getCap() {
		return cap;
	}
	
	// 동사적 특징(메소드)
	/**
	 * 입력된 메시지를 생성된 마카펜으로 칠판에 쓰는 일
	 * 
	 * @param msg 칠판에 쓸 메시지
	 * @return 결과
	 */
	String write(String msg) {
		return color+"인 마카펜으로 칠판에 \""+msg+"\" 를 쓴다";
	}
}
