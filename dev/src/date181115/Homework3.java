/*
3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는
     코드를 작성하세요.
*/
class Homework3{
	public static void main(String[] args){
		
		boolean b1 = true;
		boolean b2 = false;

		// 전항이 true기 때문에 후항의 값은 변함없이 여전히 false(연산 안함)
		System.out.println((b1=true)||(b2=true));
		System.out.println(b1+" / "+b2);	// true / false
	
		// 전항이 false면 후항도 연산을 해서 값이 바뀜
		System.out.println((b1=false)||(b2=true));
		System.out.println(b1+" / "+b2);	// false / true
	
	}
}
