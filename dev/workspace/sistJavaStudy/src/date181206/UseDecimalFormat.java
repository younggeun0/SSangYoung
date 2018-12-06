package date181206;

import java.text.DecimalFormat;

/**
 * DecimalFormat<br>
 * ���ڸ� ������ ���ڿ��� ����
 * @author owner
 */
public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		int temp = 20181206;
		
		// �����Ͱ� ���� 0�� ä��
		DecimalFormat df = new DecimalFormat("0,000,000,000");
		// �����Ͱ� ������ ä���� ����
		DecimalFormat df1 = new DecimalFormat("#,###,###,###");
		
		System.out.println("0��� : "+df.format(temp)); // 0,020,181,206 
		System.out.println("#��� : "+df1.format(temp)); // 20,181,206
		
		DecimalFormat df2 = new DecimalFormat("#,###.00");
		// �Ǽ��ڸ����� ����ϸ� ������ ���ڸ��� ���� 
		// �ݿø�����̶�� �ݿø��� ����� �����ش�.
		System.out.println("�Ҽ��ڸ��� ǥ�� : "+df2.format(201812.066)); // 201,812.07
	}
	
	public static void main(String[] args) {
		new UseDecimalFormat();
	}
}
