package date181218;

public class UseTest {

	public void useTest(Test test) {
		
		if (test instanceof TestImpl) {
			String date = test.getDate();
			System.out.println(date);
		} else {
			System.out.println("TestImpl만 처리합니다.");
		}
	}
	
	public static void main(String[] args) {
		
		UseTest ut = new UseTest();

		TestImpl ti = new TestImpl();
		TestImpl1 ti1 = new TestImpl1(); 
		
		ut.useTest(ti);
		ut.useTest(ti1);
	}
}
