package date181130;

import java.util.Date;

public class OverrideEx {
	
	@Deprecated
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.getYear());
		
		@SuppressWarnings("unused")
		int i;
	}
	
	
}
