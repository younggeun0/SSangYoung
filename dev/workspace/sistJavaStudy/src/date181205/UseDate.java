package date181205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * �����ִ� ��¥ ������ ���� �� 
 * ���� - java.text.SimpleDateFormat 
 * ��¥���� - java.util.Date
 * @author owner
 */
public class UseDate {
	
	public UseDate() {
		Date date = new Date();
		
		/*System.out.println(date);
		// 1900�� ���ؾ� ����ε� Year����(Deprecated)
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
		
		sdf = new SimpleDateFormat("yyyy��MM"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12
		
		sdf = new SimpleDateFormat("yyyy��M"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12
		
		sdf = new SimpleDateFormat("yyyy��MM��dd��"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05��
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ����
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a HH"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 15
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a hh"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 03
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a HH(hh,kk)"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 15(03,15)
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a HH(hh,kk):mm"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 15(03,15):39
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a HH(hh,kk):mm:ss"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 15(03,15):39:36
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a HH(hh,kk):mm:ss E����"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 15(03,15):39:36 ������
		
		sdf = new SimpleDateFormat("yyyy��MM��dd�� a HH(hh,kk):mm:ss EEEE"); 
		formatDate = sdf.format(date);
		System.out.println(formatDate);	// 2018��12��05�� ���� 15(03,15):39:36 ������
		
		// �������� ����ϸ� �ٸ� ������ ��¥ ������ ����� �� �ִ�.
		// 2018 12 05 PM 15(03,15):47:23 Wednesday
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.UK);
		// 2018 12 05 ���� 15(03,15):47:23 �����
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.JAPAN);
		// 2018 12 05 PM 15(03,15):47:23 mercredi
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.FRANCE);
		// 2018 12 05 ���� 15(03,15):47:23 ��Ѣ߲
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.CHINESE);
		// 2018 12 05 PM 15(03,15):47:23 Mittwoch
		sdf = new SimpleDateFormat("yyyy MM dd a HH(hh,kk):mm:ss EEEE", Locale.GERMANY);
	}
	
	public static void main(String[] args) {
		new UseDate();
	}
}
