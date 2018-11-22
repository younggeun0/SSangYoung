package date181122;

public class Method {
	
	// 1.
	public static void sysoHello() {
		System.out.println("Hello");
	}
	
	// 2.
	public static void sysoText(String text) {
		System.out.println(text);
	}
	
	// 3.
	public static int getTen() {
		return 10;
	}
	
	// 4.
	public static int sumTwoNum(int i, int j) {
		return i+j;
	}
	
	public static void main(String[] args) {
		
		// 1.
		Method.sysoHello();
		
		// 2.
		Method.sysoText("Nodsfsdfsdsd way..");
		
		// 3.
		int i = Method.getTen();
		System.out.println(i);
		
		// 4.
		System.out.println(Method.sumTwoNum(5, 3));
		
	}
}
