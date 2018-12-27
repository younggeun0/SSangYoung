package date181227;

import java.util.Random;

/**
 * running 상태에서 block 상태로 상태 이전(생명주기)
 * @author owner
 */
public class UseSleep implements Runnable {

	@Override
	public void run() {
		/*for(int i=0; i<100 ; i++) {
			System.out.println("2 * "+i+" = "+ (2*i)); // running 상태
			try {
				Thread.sleep(1000);	// block 상태
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
