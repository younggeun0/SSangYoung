package date181218;

public class ConstructorThrowsSub extends ConstructorThrows {

	// �θ�Ŭ������ �����ڰ� ������ ���ܸ� ������ �ڽ�Ŭ����
	// �����ڿ����� ���ܸ� ������ �Ѵ�.
	public ConstructorThrowsSub() throws ClassNotFoundException {
		super();
		// super�� �������� ù��° �ٿ����� ����� �� ����
		// �θ�Ŭ������ �����ڰ� Compile Exception�� throws�� ������
		// �����ڸ� ȣ���ϴ� �ڽĻ����ڿ����� �ݵ�� ó���ؾ��ϴ� 
		// ������ ������ �߻��ϰ� �ȴ�.
		/*try {
			super();
		} catch (ClassNotFoundException cnfe) {
			
		}*/
	}

	public static void main(String[] args) {
		
	}
}
