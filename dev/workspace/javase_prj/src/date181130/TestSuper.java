package date181130;

/**
 * 부모클래스 : 자식이 사용할 공통코드를 정의
 * @author owner
 */
public class TestSuper {

	int p_i;
	int p_j;
	
	public TestSuper() {
		System.out.println("부모기본생성자");
	}
	
	public void method() {
		System.out.println("부모 메소드 p_i="+p_i+", p_j="+p_j);
	}
}
