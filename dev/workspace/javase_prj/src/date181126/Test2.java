package date181126;

public class Test2 {

	int i;
	int j;
	
	public void swap(Test2 t) {
		int temp = 0;
		temp = t.i;
		t.i = t.j;
		t.j = temp;
	}
	
	public static void main(String[] args) {
		
		Test2 t2 = new Test2();
		
		t2.i = 100;
		t2.j = 300;
		
		System.out.println(t2.i+" "+t2.j); // 100 300
		t2.swap(t2);
		System.out.println(t2.i+" "+t2.j); // 300 100
	}
}
