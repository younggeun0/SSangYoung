package date181204;

/**
 *
 * @author owner
 */
public class Outer {
	
	int i;

	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}
	
	public void outMethod() {
		System.out.println("바깥 클래스의 method, i="+i);
		// 안쪽클래스를 객체화
		Outer.Inner in = this.new Inner();
		in.inMethod();
	}
	
	////////////////////// 안쪽 클래스 시작 ////////////////////////
	public class Inner {
		int j;
		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}
		public void inMethod() {
			// 안쪽클래스에선 바깥클래스의 변수, method를 사용가능
			System.out.println("안쪽 클래스의 method, j="
					+j+", 바깥 클래스의 자원 i="+i);
		}
	}
	////////////////////// 안쪽 클래스 끝 //////////////////////////
	
	public static void main(String[] args) {

		// 1. 바깥 클래스의 객체화
		Outer out = new Outer();
		out.i = 10;
		out.outMethod();
		
		// 안쪽클래스의 자원을 직접 접근사용불가
		// out.j = 20; 
		// out.inMethod();
		
		// 2. 안쪽 클래스의 객체화(바깥 클래스 객체사용)
		// 바깥클래스명.안쪽클래스명 객체명 = 바깥클래스의객체명.new 안쪽생성자();
		// Outer.Inner in = out.new Inner(); // 바깥클래스명은 생략할 수 있다.
		/*Inner in = out.new Inner();
		
		in.j = 12;
		in.inMethod();*/
	}
}
