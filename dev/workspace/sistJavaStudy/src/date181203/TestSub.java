package date181203;

public class TestSub extends TestSuper {
	
	int i;
	int j;
	
	public TestSub() {
		super();
		System.out.println("�ڽĻ�����");
	}
	public void subMethod() { System.out.println("�ڽ� subMethod"); }
	public void printJ() {
		System.out.println("�ڽ� j="+j);
	}
	@Override
	public void printI() {
		System.out.println("�ڽ��� Override�� method i="+this.i+", �θ��� i="+super.i);
	}
}
