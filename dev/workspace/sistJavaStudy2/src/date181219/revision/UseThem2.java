package date181219.revision;

public class UseThem2 {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		
		b.bMethod(a); // b라는 B클래스 객체가 a라는 A클래스 객체를 갖는 관계
	}
}
