package date181203;

public class TestSub2 extends TestSuper {
	
	int i;
	int j;
	
	public TestSub2() {
		super();
		System.out.println("자식생성자2222222");
	}
	public void subMethod() { System.out.println("자식 subMethod2222222"); }
	public void printJ() {
		System.out.println("자식 j="+j);
	}
	@Override
	public void printI() {
		System.out.println("자식2222이 Override한 method i="+this.i+", 부모의 i="+super.i);
	}
}
