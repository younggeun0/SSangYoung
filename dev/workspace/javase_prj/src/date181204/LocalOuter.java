package date181204;

/**
 * method안에 클래스를 정의하는 지역class 사용.<br>
 * 생성된 객체를 지역변수처럼 사용하는 클래스
 * 
 * @author owner
 */
public class LocalOuter {

	int i;

	public LocalOuter() {
		System.out.println("바깥 클래스의 생성자");
	}

	public void method(int param_i, final int param_j) { // parameter는 지역변수

		int local_i = 0;
		final int local_j = 0;

		/////////////////////// 지역 클래스 시작 //////////////////////////
		class Local {
			int loc_i;

			public Local() {
				System.out.println("지역 클래스의 생성자");
			}
			
			public void locMethod() {
				System.out.println("지역 클래스의 method");
				System.out.println("외부 클래스의 instance 변수 i="+i);
				
				// jdk 1.8이전은 final이 붙은 지역변수만 사용가능
				System.out.println("매개변수(parameter) param_i="
						+param_i+", param_j="+param_j);
				System.out.println("지역변수 local_i="
						+local_i+", local_j="+local_j);
				// jdk1.8부터는 final이 붙지 않은 지역변수의 출력은 가능하지만
				// final이 붙지 않아도 값할당은 되지 않는다(final처럼 사용) 
				// local_i = 2018;  
				// pram_i = 2018;
			}
		}
		/////////////////////// 지역 클래스 끝 ////////////////////////////
		// 지역클래스를 사용하려면 메소드에서 지역클래스 객체화 필요
		
		// 지역클래스의 객체화
		Local lo = new Local();
		
		// 생성된 객체로 클래스내 자원을 사용할 수 있다.
		// loc_i=100; // 직접 사용불가
		lo.loc_i=100;
		lo.locMethod();
		System.out.println(lo.loc_i);
		
		System.out.println("method 호출");
	}

	public static void main(String[] args) {

		LocalOuter lo = new LocalOuter();
		lo.method(4, 12);
	}
}
