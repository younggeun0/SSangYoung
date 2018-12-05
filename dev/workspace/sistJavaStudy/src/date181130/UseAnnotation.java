package date181130;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk 1.5�������� �߰��� annotation�� ��� Deprecated, Override, SuppressWarnings
 * 
 * @author owner
 */
public class UseAnnotation {

	/**
	 * �ش� �޼ҵ�� ���Ŀ� ������ �߻���ų �� �ִ�.
	 */
	@Deprecated
	public void test() {
		System.out.println("���Ŀ� ������ �߻��� method");
	}

	@Override
	public String toString() {
		return "�´����ʸ�";
	}

	// �޼ҵ� ���� �����ϸ� �޼ҵ� �ȿ� �ִ� ��� ��� ��Ȳ�� ����
	// ���� ���Ÿ���� �Ѳ����� �����Ϸ��� �߰�ȣ�� ���
	@SuppressWarnings({ "rawtypes", "unused" })
	public void temp() {
		// unused�� ������ ������� ���� ��
		@SuppressWarnings("unused")
		int i = 0;

		// rawypes : Generic�� ������� ���� �� ��� ����
		// �������� �����ϸ� Ư�������� ����
		// @SuppressWarnings({ "rawtypes", "unused" })
		List l = new ArrayList();

		int j = 0;
		System.out.println(j);
	}

	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.test();

		System.out.println(ua);
	}
}
