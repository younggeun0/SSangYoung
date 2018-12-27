package date181227;

import java.util.Random;

/**
 * running ���¿��� block ���·� ���� ����(�����ֱ�)
 * @author owner
 */
public class UseSleep implements Runnable {

	@Override
	public void run() {
		/*for(int i=0; i<100 ; i++) {
			System.out.println("2 * "+i+" = "+ (2*i)); // running ����
			try {
				Thread.sleep(1000);	// block ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}*/
		System.out.print("loading");
		Random r = new Random();
		for(int i=0; i<15; i++) {
			System.out.print(" . ");
			try {
				Thread.sleep(100*r.nextInt(10)+1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("finish");
	}
	
	public static void main(String[] args) {
		UseSleep us = new UseSleep();
		Thread th = new Thread(us);
		th.start();
	}
}
