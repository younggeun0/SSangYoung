package algorithm;

public class Test03 {

	public static void main(String[] args) {
		
		int sum = 0;
		int flag = -1;
		
		for(int i=1; i<101; i++) {
			flag = flag*(-1);
			sum += (flag)*i;
			System.out.println((flag)*i);
		}
		
		System.out.println(sum);
	}
}
