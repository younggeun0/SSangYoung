package date181203;

/**
 * ���� Ŭ����(�ڽ�Ŭ����)���� �ݵ�� �����ؾ��ϴ� ���� ��ϸ�
 * �����ϴ� interface�� ����(������ ������)
 * @author owner
 */
// interface�� �θ� ������ ���� �� �ִ�.
public interface SuperInterface extends InterA, InterB {
	
	// �������̽��� ��ӿ��� �߻�method�� Override���� �ʴ´�!

	// constant : ������ ���ó�� ���.
	// ������ �ۼ��� �� ����.
	public static final int FLAG_VALUE = 12;
	
	// �߻� method ����
	// �Ϲ� �޼ҵ�� ���� �� ����. error!
	// public void test() {}
	
	// abstract ������� �ʾƵ� abstract method
	public void methodA();	// abstract method
	public abstract void methodB(String i);

	
}
