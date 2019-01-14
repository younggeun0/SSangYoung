package example;

public class CallByValue {

	public int sum(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		
		CallByValue cbv = new CallByValue();
		
		System.out.println(cbv.sum(1, 3));
		// 값을 전달하는 call by value
	}
}
