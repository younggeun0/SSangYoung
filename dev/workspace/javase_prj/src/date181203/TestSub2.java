package date181203;

public class TestSub2 extends TestSuper {
	
	int i;
	int j;
	
	public TestSub2() {
		super();
		System.out.println("�ڽĻ�����2222222");
	}
	public void subMethod() { System.out.println("�ڽ� subMethod2222222"); }
	public void printJ() {
		System.out.println("�ڽ� j="+j);
	}
	@Override
	public void printI() {
		System.out.println("�ڽ�2222�� Override�� method i="+this.i+", �θ��� i="+super.i);
	}
}
