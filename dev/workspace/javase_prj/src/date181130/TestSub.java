package date181130;

/**
 * TestSuper의 자식 클래스
 * @author owner
 */
public class TestSub extends TestSuper {

	int p_j;
	
	public TestSub() {
		System.out.println("자식기본생성자");
	}
	
	@Override
	public void method() {
		p_i=400;	// 코드의 재사용성 증가, 부모의 변수 p_i
		p_j=500;	// 같은 이름의 변수가 존재하면 자식의 것을 사용
		
		
		System.out.println("자식 메소드 p_i="+this.p_i+", p_j="+this.p_j);
		super.method();
		
		System.out.println(this);
		// System.out.println(super); // super는 출력할 수 없다.
	}
	
	public static void main(String[] args) {

		TestSub ts = new TestSub();
		
		
		ts.method();
		
	}

}
