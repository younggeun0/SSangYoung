package date181218;

import java.util.Stack;

/**
 * 객체 복제 : 복제되는 객체는 Clonable Interface를 구현해야하만 한다.
 * @author owner
 */
public class ObjectClone implements Cloneable {
	
	private int i;

	public static void main(String[] args) {
	
		ObjectClone oc = new ObjectClone();
		oc.i = 100;
		
		try {
			// 현재 상태를 저장하기 위해 복제
			ObjectClone oc1 = (ObjectClone)oc.clone();
			
			System.out.println("복제성공 oc : "+oc+", oc1 : "+oc1);
			
			oc.i = 200; // 현재객체의 상태가 변경
			
			System.out.println("원본 : "+oc.i+" / 복제본 : "+oc1.i);
			
			
		} catch (CloneNotSupportedException cnse) {
			System.err.println("복제실패");
			cnse.printStackTrace();
		}
	}
}
