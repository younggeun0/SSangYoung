package date181128;

/**
 * 행마다 열의 개수가 다른 가변 배열
 * @author owner
 */
public class VariableArray {

	public VariableArray() {
		// 1.선언) 데이터형[][] 배열명 = null;
		int[][] arr = null;
		
		// 2.생성) 행의 개수만 설정. 배열명==new 데이터형[행의수][];
		arr=new int[4][];
		
//		System.out.println(arr.length);
		
		// 3.행마다 열생성) 배열명[행번호] = new 데이터형[열의개수];
		arr[0] = new int[3];
		arr[1] = new int[4];
		arr[2] = new int[1];
		// 초기화를 하려면 열의 개수는 설정하지 않는다.
		arr[3] = new int[] {1, 2, 3, 4, 5, 6};
		
		// 4.값할당
		arr[0][2] = 10;
		arr[1][3] = 20;
		arr[2][0] = 30;
		
		// 5. 값사용 
		System.out.println(arr[0][0]+" / "+arr[0][1]+" / "+arr[0][2]);
		
		
		// 모든 방의 값 출력 : 일괄처리
		System.out.println("모든 결과 출력 ");
		for(int i=0; i<arr.length ; i++) { // 행
			for(int j=0; j<arr[i].length; j++) { // 열
				System.out.printf("arr[%d][%d]=%-5d", i,j,arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new VariableArray();
	}
}
