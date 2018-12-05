package date181120;

public class EnhancedFor01 {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 300, 15};
		
		System.out.println("기존 for");
		// i는 요소의 인덱스
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("향상된 for");
		
		// 향상된 for에선 i가 요소의 값을 갖게 됨
		for(int i:arr) {
			System.out.println(i);
		}
	}
}
