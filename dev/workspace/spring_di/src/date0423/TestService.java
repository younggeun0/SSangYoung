package date0423;

public class TestService {
	
	// 의존성 주입받은 객체를 사용할 수 있도록 
	// instance 변수로 선언
	private TestDAO td;
	
	// interface를 의존성 주입받으면 약결합이 됨
	// (이 예제에선 클래스를 받아서 강결합)
	public TestService(TestDAO td) {
		this.td = td;
		System.out.println("생성자 의존성 주입");
	}
	

	public TestService() {
		System.out.println("기본 생성자를 사용하여 객체 생성");
	}
	
	// method 의존성 주입, 반드시 기본 생성자가 존재해야 한다.
	public void setTd(TestDAO td) {
		this.td = td;
	}
	
	public TestDAO getTd() {
		return td;
	}
}
