package date181206;

import java.util.Calendar;
import java.util.GregorianCalendar;
public class UseCalendar {
	public UseCalendar() {
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = new GregorianCalendar();
		GregorianCalendar gc = new GregorianCalendar();
		
		int year = cal.get(Calendar.YEAR);
		// ��, java������ ���� ������ 0��
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		// ���� ���° ������
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		
		System.out.printf("%d-%d-%d ������ ������ %d��° ��\n",
				year,month,day,dayOfYear);

		// ���� : ��(1), ��(2), ȭ(3), ��(4), ��(5), ��(6), ��(7)
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		/*switch(dayOfWeek) { // case 1~7, �������� ����
		case 1:	System.out.println("�Ͽ���");	break;
		case 2:	System.out.println("������");	break;
		case 3:	System.out.println("ȭ����");	break;
		case 4:	System.out.println("������");	break;
		case 5:	System.out.println("�����");	break;
		case 6:	System.out.println("�ݿ���");	break;
		case 7:	System.out.println("�����");	break;
		}*/
		
		/*String week="";
		// ��� ����Ͽ� ������ ���
		switch(dayOfWeek) { 
		case Calendar.SUNDAY:
			week="�Ͽ���";	break;
		case Calendar.MONDAY:
			week="������";	break;
		case Calendar.TUESDAY:
			week="ȭ����";	break;
		case Calendar.WEDNESDAY:
			week="������";	break;
		case Calendar.THURSDAY:
			week="�����";	break;
		case Calendar.FRIDAY:
			week="�ݿ���";	break;
		case Calendar.SATURDAY:
			week="�����";	break;
		}
		System.out.printf("%d���� %s\n",dayOfWeek, week);*/
		
		// �迭 Ȱ���ϴ� ���(����)
		String[] weekTitle = { "��","��","ȭ","��","��","��","��" };
		System.out.printf("%d���� %s����\n",dayOfWeek, 
				weekTitle[dayOfWeek-1]);
		
		// ����(0) ����(1)
		int amPm = cal.get(Calendar.AM_PM);
		
		// ��� Calendar.AM, Calendar.PM�� �̷��� ���
		/*switch(amPm) {
		case Calendar.AM:
			System.out.println("����");
			break;
		case Calendar.PM:
			System.out.println("����");
			break;
		}*/
		
		// �迭��
		String[] arrAmPm = { "����", "����" };
		System.out.printf("%d %s\n",amPm, arrAmPm[amPm]);
	
		// ���׿����ڷ�
		System.out.printf("%s\n", amPm == Calendar.AM ? "����" : "����");
		
		// �ð�
		int hour = cal.get(Calendar.HOUR);	// 12�ð���
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24�ð���
		System.out.printf("%d(%d)��\n", hour, hour24);
		
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d(%d):%d:%d\n",hour,hour24,minute,second);
		
		// Calendar�� ������ ������ ��¥ ������ ����
		// �ٸ� ��¥�� ��� ���ؼ� set�� ���
		System.out.println("-----------------------------------------------");
		System.out.printf("���� �� %d-%d-%d %s����\n",
			cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH)+1,
			cal1.get(Calendar.DAY_OF_MONTH),
			"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		// ��
		cal1.set(Calendar.YEAR, 2019);
		// �� - ����� �����ϴ� ������ 1���� ����
		cal1.set(Calendar.MONTH, 4);
		// �� - �ش���� �������� �ʴ� ���ڰ� �����Ǹ� �ڵ����� �����޷� �Ѿ ������
		cal1.set(Calendar.DAY_OF_MONTH, 32);
		
		System.out.printf("���� �� %d-%d-%d %s����\n",
				cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH)+1, 
				cal1.get(Calendar.DAY_OF_MONTH),
				"��,��,ȭ,��,��,��,��".split(",")[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println("-----------------------------------------------");
		
		// �̹����� ������ ���� �� �� �ִ� getActualMaximum
		System.out.println(cal1.getActualMaximum(Calendar.DATE));
		System.out.println(cal1.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
	public static void main(String[] args) {
		new UseCalendar();
	}
}
