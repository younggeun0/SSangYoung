package example;

public class CallByValue {

	public int sum(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		
		CallByValue cbv = new CallByValue();
		
		System.out.println(cbv.sum(1, 3));
		// ���� �����ϴ� call by value
	}
}
