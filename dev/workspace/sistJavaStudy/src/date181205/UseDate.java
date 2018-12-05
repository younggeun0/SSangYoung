package date181205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 형식있는 날짜 정보를 얻을 때 
 * 형식 - java.text.SimpleDateFormat 
 * 날짜정보 - java.util.Date
 * @author owner
 */
public class UseDate {
	
	public UseDate() {
		Date date = new Date();
		
		/*System.out.println(date);
		// 1900을 더해야 제대로된 Year나옴(Deprecated)
		System.out.println(date.getYear()+1900); */
	
		SimpleDateFormat sdf = new SimpleDateFormat("y"); 
		String formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018

		sdf = new SimpleDateFormat("yy"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 18
		
		sdf = new SimpleDateFormat("yyyy"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018
		
		sdf = new SimpleDateFormat("yyyy년MM"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12
		
		sdf = new SimpleDateFormat("yyyy년M"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a HH"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 15
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a hh"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 03
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a HH(hh,kk)"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 15(03,15)
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a HH(hh,kk):mm"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 15(03,15):39
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a HH(hh,kk):mm:ss"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 15(03,15):39:36
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a HH(hh,kk):mm:ss E요일"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 15(03,15):39:36 수요일
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일 a HH(hh,kk):mm:ss EEEE"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018년12월05일 오후 15(03,15):39:36 수요일
		
		// 로케일을 사용하면 다른 나라의 날짜 형식을 사용할 수 있다.
		// 2018 12 05 PM 15(03,15):47:23 Wednesday
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.UK);
		// 2018 12 05 午後 15(03,15):47:23 水曜日
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.JAPAN);
		// 2018 12 05 PM 15(03,15):47:23 mercredi
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.FRANCE);
		// 2018 12 05 下午 15(03,15):47:23 星期三
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.CHINESE);
		// 2018 12 05 PM 15(03,15):47:23 Mittwoch
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.GERMANY);
	}
	
	public static void main(String[] args) {
		new UseDate();
	}
}
