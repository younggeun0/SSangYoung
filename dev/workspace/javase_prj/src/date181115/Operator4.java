package date181115;
/*
	관계 연산자
	 >, <, >=, <=, ==, !=
*/
class Operator4 {
	public static void main(String[] args) {
		
		int i=11, j=15, k=11;

		System.out.println(i+" == "+k+" = " + (i==k)); // true
		System.out.println(i+" == "+j+" = " + (i==j)); // false

		System.out.println(i+" != "+k+" = " + (i!=k)); // false
		System.out.println(i+" != "+j+" = " + (i!=j)); // true
	}
}
