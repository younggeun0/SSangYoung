package date181126;

/**
 * method의 매개변수가 참조데이터형(class, 문자열, array)인 경우
 * arguments를 넣으면 동일한 하나의 주소가 할당된다.
 * (값을 변경하면 생성된 객체가 가진 값이 변경된다.)
 * @author owner
 */
public class CallByReference {

	int i;
    int j;
	
	public void swap(CallByReference cbr) {
		int temp = 0;
		temp = cbr.i;
		cbr.i = cbr.j;
		cbr.j = temp;
		System.out.println("swap method내 i="+i+", j="+j);
	}
	
	public static void main(String[] args) {
		
		CallByReference cbr = new CallByReference();
		cbr.i = 12;
		cbr.j = 22;
		
		System.out.println("sawp 전 값 i="+cbr.i+", j="+cbr.j);
		// 주소가 그대로 전달
		cbr.swap(cbr);
		
		System.out.println("sawp 후 값 i="+cbr.i+", j="+cbr.j);
	}
}
