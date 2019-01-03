package date190103;

public class UseLambda3 {
	
	public static void main(String[] args) {

		Thread t = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			}
		});
		
		t.start();
		for(int i=0; i<1000; i++) {
			System.out.println("main ---- i = "+i);
		}
	}
}
