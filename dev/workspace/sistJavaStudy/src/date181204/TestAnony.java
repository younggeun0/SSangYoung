package date181204;

/**
 * anonymous inner class<br>
 * 인터페이스가 method의 매개변수일 때 간단하게 사용하는 방법<br>
 * 1회성
 * 
 * @author owner
 */
public class TestAnony{
	
	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}

	public static void main(String[] args) {
		
		// interface는 객체화가 되지 않는다.
		// AnonyInter ai = new AnonyInter();
		
		// interface가 매개변수 였을 때
		// 1. 인터페이스를 구현한 클래스를 생성
		// 2. 구현클래스로 객체를 생성
		AnonyInter ai = new AnonyImpl(); // is-a
		
		// 3. 매개변수를 가진 메소드를 호출하기위해 객체생성
		TestAnony ta = new TestAnony();
		
		// 4. method 호출
		ta.useAnonyInter(ai);
		
		// interface를 매개변수로 받으면 절차가 많다
		// 때문에 나온게 anonymous class
		
		System.out.println("---------------anonymous inner class -----------------");
		// anonymous inner class를 사용하면 class를 따로 만들 필요가 없다.
		ta.useAnonyInter(new AnonyInter() {
			@Override
			public String getName() {
				return "공선의"+test();
			}
			@Override
			public String getMsg() {
				return "안녕하세요";
			}
			public String test() {
				return " 자식 method";
			}
		});
	}
}
