package date0423;

public class TestService2 {
	
	// 의존성 주입받은 객체를 사용할 수 있도록 
	// instance 변수로 선언
	private TestDAO td;
	private TestDAO2 td2;
	
	// interface를 의존성 주입받으면 약결합이 됨
	// (이 예제에선 클래스를 받아서 강결합)
	public TestService2(TestDAO td, TestDAO2 td2) {
		this.td = td;
		this.td2 = td2;
		System.out.println("매개변수가 여러개인 생성자 의존성 주입");
	}
}

