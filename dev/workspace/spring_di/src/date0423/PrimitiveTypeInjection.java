package date0423;

public class PrimitiveTypeInjection {

	public PrimitiveTypeInjection(int i) {
		System.out.println("기본형 데이터형 int를 매개변수로 Injection i="+i);
	}
	
	public PrimitiveTypeInjection(long l) {
		System.out.println("기본형 데이터형 long을 매개변수로 Injection l="+l);
	}
	
	public PrimitiveTypeInjection(String s) {
		System.out.println("문자열 데이터형을 매개변수로 Injection s="+s);
	}
}
