package date181129;

/**
 * TestSuper의 자식클래스 
 * 
 * @author owner
 */
public class TestSub extends TestSuper {
	
	int i;
	
	public TestSub() {
		System.out.println("자식클래스 기본생성자");
	}
	
	public void subMethod() {
		System.out.println("자식클래스의 method");
	}
	
	public static void main(String[] args) {
		// 객체화는 자식클래스를 사용한다.
		TestSub ts = new TestSub();
		
		// 자식과 부모가 같은 패키지에 존재하면 부모가 가진
		// 변수나 method의 접근지정자가 public, protected, 
		// default인 자원만 사용할 수 있다.
		ts.public_i = 10;
		ts.protected_i = 20;
		ts.default_i = 30;
		
		System.out.println("부모의 자원 "+ts.public_i+"/"
				+ts.protected_i+"/"+ts.default_i);
		
		ts.i = 100;
		
		System.out.println("자식의 자원 "+ts.i);
		
		ts.superMethod();
		ts.subMethod();
	}
}
