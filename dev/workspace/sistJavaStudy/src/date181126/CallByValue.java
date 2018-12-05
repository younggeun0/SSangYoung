package date181126;

/**
 * method의 매개변수가 기본형으로 정의된다면
 * 매개변수에 할당되는 값은 복사되어 전달된다.
 * 매개변수의 값을 변경하더라도 원래의 값은 변경되지 않는다. 
 * => Call By Value
 * @author owner
 */
public class CallByValue {

	public void swap(int i, int j) {
		
		// 입력되는 변수의 값을 서로 변경.
		int temp = 0;
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap method called");
		System.out.println(i+" "+j);
	}
	
	public static void main(String[] args) {
		
		int i=11, j=26;
		System.out.println(i+" "+j);
		
		CallByValue cbv = new CallByValue();
		cbv.swap(i, j);
		
		System.out.println(i+" "+j);
	}
}
