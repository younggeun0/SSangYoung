package date181218;

import java.util.Stack;

/**
 * ��ü ���� : �����Ǵ� ��ü�� Clonable Interface�� �����ؾ��ϸ� �Ѵ�.
 * @author owner
 */
public class ObjectClone implements Cloneable {
	
	private int i;

	public static void main(String[] args) {
	
		ObjectClone oc = new ObjectClone();
		oc.i = 100;
		
		try {
			// ���� ���¸� �����ϱ� ���� ����
			ObjectClone oc1 = (ObjectClone)oc.clone();
			
			System.out.println("�������� oc : "+oc+", oc1 : "+oc1);
			
			oc.i = 200; // ���簴ü�� ���°� ����
			
			System.out.println("���� : "+oc.i+" / ������ : "+oc1.i);
			
			
		} catch (CloneNotSupportedException cnse) {
			System.err.println("��������");
			cnse.printStackTrace();
		}
	}
}
