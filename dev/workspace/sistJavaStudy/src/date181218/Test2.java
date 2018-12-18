package date181218;

public class Test2 {
	
	public void test2() {
		
		int[] arrInt = { 1, 2, 3 };
		
		System.out.println(arrInt[4]);
	}

	public static void main(String[] args) {

		Test2 t2 = new Test2();
		
		try {
			throw new ArrayIndexOutOfBoundsException();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("¿¡·¯");
		}
		
	}
}
