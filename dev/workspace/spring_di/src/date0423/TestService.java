package date0423;

public class TestService {
	
	// ������ ���Թ��� ��ü�� ����� �� �ֵ��� 
	// instance ������ ����
	private TestDAO td;
	
	// interface�� ������ ���Թ����� ������� ��
	// (�� �������� Ŭ������ �޾Ƽ� ������)
	public TestService(TestDAO td) {
		this.td = td;
		System.out.println("������ ������ ����");
	}
	

	public TestService() {
		System.out.println("�⺻ �����ڸ� ����Ͽ� ��ü ����");
	}
	
	// method ������ ����, �ݵ�� �⺻ �����ڰ� �����ؾ� �Ѵ�.
	public void setTd(TestDAO td) {
		this.td = td;
	}
	
	public TestDAO getTd() {
		return td;
	}
}
