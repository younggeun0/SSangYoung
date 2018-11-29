package date181129;

/**
 * private로 된 배열을 public method로 내보내면 
 * 외부에서 private 배열값을 수정할 수 있게 된다.
 * (안전한 코딩 - 배열을 복사 해 리턴해서 해결)
 * 
 * @author owner
 */
public class SecureArray {
	
	private int[] arr = { 1,2,3,4,5 };
	
	public int[] getArr() {
		return arr;
	}
}

