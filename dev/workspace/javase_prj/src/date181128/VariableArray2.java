package date181128;

/**
 * 가변 배열의 기본형 형식 사용
 */
public class VariableArray2 {
	public void priType() {
		
		// 문법) 데이터형[][] 배열명 = { {값,.}, {..}, ... };
		// 행구분 괄호로 묶여지는 값의 개수를 다르게 설정
		String[][] arr = { 
			{"딸기"},
			{"포도","수박", "복숭아"},
			{"사과","배", "감"},
			{"뀰"} 
		};
		
		String[] title = { "봄","여름","가을","겨울" };
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(title[i]+" : ");
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		new VariableArray2().priType();
	}
}
