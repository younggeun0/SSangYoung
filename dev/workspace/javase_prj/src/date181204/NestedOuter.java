package date181204;

/**
 * 내부클래스를 static 변수처럼 사용할 수 있는 중첩클래스(nested class)
 * 
 * @author owner
 */
public class NestedOuter {
	
	int i;
	static int j;

	public NestedOuter() {
		System.out.println("바깥클래스 생성자");
	}
	
	public void outInstanceMethod() {
		System.out.println("바깥클래스의 instance method");
	}
	
	public static void outStaticMethod() {
		System.out.println("바깥클래스의 static method");
	}
	
	/////////////////////// Nested class 시작 ///////////////////
	public static class NestedInner {
		// int instance_i; // instance 변수, instance 생성 권장안함
		static int instance_j; // static 변수
		
		/*public NestedInner() { // 생성자 권장안함(static 클래스이므로)
			System.out.println("중첩클래스 생성자");
		}*/
		
		public void inMethod() { // 객체화없이 사용불가
			System.out.println("안쪽 클래스의 instance method");
		}
		
		public static void inStaticMethod() {
			System.out.println("안쪽 클래스의 static method");
			// i는 인스턴스 변수라 직접 사용불가(객체화 필요)
			System.out.println("바깥클래스의 자원 사용 "
					+ "i=사용불가, j="+NestedOuter.j); 
			// outInstanceMethod(); // 인스턴스 메소드라 사용불가
			NestedOuter.outStaticMethod();
		}
	}
	/////////////////////// Nested class 끝 /////////////////////
	
	public static void main(String[] args) {

		// static 영역을 사용할 때에는 객체화없이 클래스명.변수명,
		// 클래스명.method명으로 사용(static 방식)
		
		// NestedInner.inMethod(); // 객체화 안해서 사용불가
		NestedInner.inStaticMethod();
		
		// 중첩클래스는 객체화 권장안함(static 이므로)
		// NestedInner ni = new NestedInner();
		// System.out.println(ni.instance_i);
		
	}
}
