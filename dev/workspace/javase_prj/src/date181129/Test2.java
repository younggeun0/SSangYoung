package date181129;

import java.util.Arrays;

class Test {
	private int[] arr = { 1, 2, 3, 4 }; 
	
	public int[] getArr() {
		int[] tmp = new int[arr.length];
		for(int i=0; i<tmp.length; i++) {
			tmp[i] = arr[i];
		}
		return tmp;
	}
}

public class Test2 {
	
	public static void main(String[] args) {
		
		Test t = new Test();
		
		int[] a = t.getArr();
		a[0] = 100;
		System.out.println(Arrays.toString(a)); // [100, 2, 3, 4]
		
		int[] b = t.getArr();
		System.out.println(Arrays.toString(b)); // [1, 2, 3, 4]
		
	}
}