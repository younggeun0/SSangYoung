package algorithm;

public class Test02 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<100; i+=2) {
			sum += i;
			System.out.println(i);
		}
		
		System.out.println(sum);
	}
}
