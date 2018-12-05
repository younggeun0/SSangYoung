package date181205;

/**
 * 1970�� 01�� 01�� 00:00:00 ���� ���� ��¥�� �ð��� ms�� ���� System.currentTimeMillis() ���
 * 
 * @author owner
 */
public class UseCurrentTime {

    public void test() {
        
        long st = System.currentTimeMillis();
        long sum = 0;
        
        for(int i=0; i<10000; i++) {
            sum = sum + i;
            // System.out.println(); ����ϸ�  ó���ӵ��� ��û ��������.
            // �׽�Ʈ ���� �����ϸ�  System.out.println�� ���� �Ⱦ���
            System.out.println(i);
        }
        
        long et = System.currentTimeMillis();
        // �ڵ� ���� �ð�
        System.out.println((et-st)+"ms");
   }

	public static void main(String[] args) {

		UseCurrentTime uct = new UseCurrentTime();
		// ���α׷� ��սð� ���ϱ�
		long[] avgTime = new long[17];
		long st=0,et = 0; 
		
		for(int i=0; i<avgTime.length; i++) {
			st=System.currentTimeMillis();
			uct.test();
			et=System.currentTimeMillis();
			avgTime[i] = (et-st);
		}
		
		System.out.println(System.nanoTime());
	}
}
