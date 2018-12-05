package date181121;

/**
 * static 변수 (class 변수)
 *  - 클래스가 실행되면 가장 처음 메모리(method)에 올라가고,
 *    모든 객체가 하나의 변수를 참조하여 사용하는 변수
 * @author owner
 */
public class UseStaticVariable {

	static int i; // static 변수 	-> 바로 사용
	int j;		  // instance 변수	-> 객체화 후 사용
	
	public void test() {
		i = 100;
		j = 200;
		System.out.println(i+" / "+j);
	}

	public static void main(String[] args) {
	
		// class 변수의 사용. 클래스명.변수명
		UseStaticVariable.i = 2000;
		
		System.out.println(UseStaticVariable.i);
		
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		
		usv.j = 5000;		// instance 변수는 생성된 객체가 각각 사용
		usv1.j = 10000;		
		
		// usv.i = 300; 
		// 객체명으로 사용하면 특정 객체에 속한 member변수가 아니므로
		// 사용은 가능하지만 권장하는 문법이 아니다. 
		UseStaticVariable.i = 10;
		
		System.out.println("usv객체 인스턴스변수 : "+usv.j
				+", 스태틱변수 :"+UseStaticVariable.i);
		System.out.println("usv1객체 인스턴스변수 : "+usv1.j
				+", 스태틱변수 :"+UseStaticVariable.i);
	}
}
