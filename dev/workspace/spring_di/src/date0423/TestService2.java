package date0423;

public class TestService2 {
	
	// ������ ���Թ��� ��ü�� ����� �� �ֵ��� 
	// instance ������ ����
	private TestDAO td;
	private TestDAO2 td2;
	
	// interface�� ������ ���Թ����� ������� ��
	// (�� �������� Ŭ������ �޾Ƽ� ������)
	public TestService2(TestDAO td, TestDAO2 td2) {
		this.td = td;
		this.td2 = td2;
		System.out.println("�Ű������� �������� ������ ������ ����");
	}
}

