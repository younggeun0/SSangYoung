package date181204;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
// 패키지는 다르나 이름이 같은 클래스는 둘 중 하나만 import 받을 수 있다.  
// import java.awt.List; 
import java.util.Random;

// import java.util.*; // 패키지 내 모든 class(interface)를 한번에 사용가능(비권장)
// Ctrl + Shift + O : 자동 import

/**
 * import : 다른 패키지의 클래스를 참조하여 사용할 때 사용
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
		
		// 같은 이름의 클래스(interface)는 둘 중 많이 사용되는 것을 import로 처리하고,
		// 적게 사용되는 것을 full path로 처리한다.
		List list = null;	// util.List
		java.awt.List list1 = null;	// awt.List
	}
}
