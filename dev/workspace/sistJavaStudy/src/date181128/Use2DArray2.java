package date181128;

/**
 * 행과 열로 구성된 2차원 배열
 * @author owner
 */
public class Use2DArray2 {

	/**
	 * 참조형 형식으로 2차원 배열 사용
	 */
	public void refType() {
		// 1.선언) 데이터형[][] 배열명 = null;
		int[][] arr = null;
		
		// 2.생성) 배열명 = new 데이터형[행의수][열의수];
		// 모든 방의 값은 초기화
		arr = new int[3][4];
		
		System.out.println(" arr의 행의 수 : "+arr.length
				+", 열의 수 : "+arr[0].length);
		
		// 1+2) 데이터형[][] 배열명 = new 데이터형[행의수][열의수];
		int[][] arr1 = new int[4][5];
		
		System.out.println("arr1의 행의 수 : "+arr1.length
				+", 열의 수 : "+arr1[0].length);
		
		// 3. 값 할당) 배열명[행번호][열번호] = 값;
		arr[0][0] = 10;
		arr[1][1] = 20;
		arr[2][2] = 30;
		
		// 4. 값 사용) 배열명[행번호][열번호]
		System.out.printf("arr[0][0]=%d, arr[0][1]=%d, "
				+ "arr[0][2]=%d\n", arr[0][0], arr[0][1],
				arr[0][2]);
		
		// 모든 요소 출력
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		
		// 향상된 for문으로 출력
		System.out.println("--------------------");
		// 2차원 배열의 한행은 일차원 배열로 이루어져있다.
		for(int[] tmpArr : arr) {
			// 1차원 배열의 방은 단일 데이터형으로 이루어졌다.
			for(int i : tmpArr) {
				System.out.printf("%4d",i);
			}
			System.out.println();
		}
	}
	
	/**
	 * 기본형 형식의 사용
	 */
	public void priType() {
		// 행구분 괄호에 따라 행이 생성.
		// 데이터형[][] 배열명 = { {값,..}, {값,.. }, ... };
		
		// 1. 선언)
		int[][] arr = { 
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		
		System.out.println("행 : "+ arr.length
				+", 열 : "+arr[0].length);
		
		// 2. 값할당)
		arr[0][0] = 100;
		
		// 3. 값사용)
		System.out.println(arr[0][0]);
		
		for(int i=0; i<arr.length; i++) { // 행
			for(int j=0; j<arr[i].length; j++) {	// 열
				System.out.printf("arr[%d][%d]=%-4d", i,j,arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// default constructor 생성됨
		// - class의 접근지정자를 따라감
		Use2DArray2 ua2 = new Use2DArray2();
		
//		System.out.println("refType-------------");
//		ua2.refType();
//		System.out.println("--------------------");
		
		System.out.println("priType-------------");
		ua2.priType();
	}
}
