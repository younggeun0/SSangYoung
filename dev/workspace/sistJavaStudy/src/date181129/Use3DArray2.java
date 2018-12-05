package date181129;

/**
 * 면, 행, 열로 이루어진 3차원 배열
 * @author owner
 */
public class Use3DArray2 {

	public Use3DArray2() {
		
		// 3차원 배열 참조형 형식의 사용
		// 1. 선언) 데이터형[][][] 배열명 = null;
		int[][][] arr = null;
		
		// 2. 생성) 배열명 = new 데이터형[][][];
		arr = new int[2][3][4];
		
		// 1+2) 데이터형[][][] 배열명 = new 데이터형[면][행][열];
		int[][][] arr1 = new int[3][4][5];
		
		arr[0][0][0] = 10;
		arr[1][2][3] = 1000;
		
		System.out.println(arr[0][0][0]+"/"+arr[0][0][1]+"/"+arr[0][0][2]);
		System.out.println("arr배열의 면의 수 : "+arr.length
				+", 행의 수 : "+arr[0].length+", 열의 수 : "+arr[0][0].length);
		System.out.println("arr1배열의 면의 수 : "+arr1.length
				+", 행의 수 : "+arr1[0].length+", 열의 수 : "+arr1[0][0].length);
		
		for(int i=0; i<arr.length; i++) {	// 면
			System.out.println(i+"면 시작");
			for(int j=0; j<arr[i].length; j++) {	// 행
				System.out.println(i+"면 "+j+"행 시작");
				for(int k=0; k<arr[i][j].length; k++) {	//열
					System.out.print(arr[i][j][k]+"\t");
				}
				System.out.println("\n"+i+"면 "+j+"행 끝");
			}
			System.out.println(i+"면 끝");
		}
		
		// 3차원 배열의 한면은 2차원 배열로 이루어져있다.
		for(int[][] arr2 : arr1) {
			
			// 2차원 배열의 한행은 1차원 배열로 이루어져있다.
			for(int[] arr0 : arr2) {
				
				// 1차원 배열의 한 열은 단일 데이터형으로 이루어져 있다.
				for(int val : arr0) {
					System.out.print(val+"\t");
				}
				System.out.println();
				System.out.println("행 끝");
			}
			System.out.println("면 끝");
		}
	}
	
	public void priType() {
		
		// 기본형 형식으로 3차원 배열선언.
		// 데이터형[][][] 배열명 = new 데이터형[][][] {
		//	{ {{값,.}...},..  }, { ... }, { ... }, ...
		// };
		int[][][] arr = {
			{
				{1,2,3,},
				{4,5,6}
			},
			{
				{7,8,9},
				{10,11,12}
			}
		};
		
		System.out.println("면의 수 :"+arr.length+", 행의 수 :"
				+arr[0].length+", 열의 수 :"+arr[0][0].length);
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				for(int k=0; k<arr[i][j].length; k++) {
					System.out.print(arr[i][j][k]+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		new Use3DArray2().priType();
	}
}
