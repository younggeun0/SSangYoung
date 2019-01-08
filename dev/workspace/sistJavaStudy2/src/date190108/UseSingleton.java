package date190108;

public class UseSingleton {

	public static void main(String[] args) {
		// Singleton Pattern���� ������� ��ü ���.
		// �����ڰ� private�̹Ƿ� Ŭ������ �ܺο��� ��üȭ�� ���� �ʴ´�.
		// Singleton s = new Singleton(); 
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}
