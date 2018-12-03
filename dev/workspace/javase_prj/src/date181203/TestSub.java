package date181203;

public class TestSub extends TestSuper {
	
	int i;
	int j;
	
	public TestSub() {
		super();
		System.out.println("자식생성자");
	}
	public void subMethod() { System.out.println("자식 subMethod"); }
	public void printJ() {
		System.out.println("자식 j="+j);
	}
	@Override
	public void printI() {
		System.out.println("자식이 Override한 method i="+this.i+", 부모의 i="+super.i);
	}
}
