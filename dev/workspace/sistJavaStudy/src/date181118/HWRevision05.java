/*
3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는
     코드를 작성하세요.
*/
package date181118;

public class HWRevision05 {

	public static void main(String[] args) {

		boolean t1 = false;
		boolean f1 = true;
		
		System.out.println(t1 + " / " + f1);
		
		System.out.println((t1=true)||(f1=false));
		
		// true만 처리하고 넘어가서 f1이 false가 안됐음
		System.out.println(t1 + " / " + f1);
		
	}
}
