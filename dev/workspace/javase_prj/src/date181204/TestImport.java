package date181204;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
// ��Ű���� �ٸ��� �̸��� ���� Ŭ������ �� �� �ϳ��� import ���� �� �ִ�.  
// import java.awt.List; 
import java.util.Random;

// import java.util.*; // ��Ű�� �� ��� class(interface)�� �ѹ��� ��밡��(�����)
// Ctrl + Shift + O : �ڵ� import

/**
 * import : �ٸ� ��Ű���� Ŭ������ �����Ͽ� ����� �� ���
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {

		Random r = new Random();
		for(int i=0; i<10; i++) {
			System.out.println(r.nextInt(40));;
		}
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		
		List strList = new ArrayList();
		java.awt.List awtList = new java.awt.List();
		
		// ���� �̸��� Ŭ����(interface)�� �� �� ���� ���Ǵ� ���� import�� ó���ϰ�,
		// ���� ���Ǵ� ���� full path�� ó���Ѵ�.
		List list = null;	// util.List
		java.awt.List list1 = null;	// awt.List
	}
}
