package date181127;

/**
 * 1차원 배열 : 행하나의 열로만 구성된 배열<br>
 * 배열 - 메모리에 동일데이터형으로 나열된 데이터형<br>
 * 참조형 데이터형, 고정길이형<br>
 * 일괄처리할 때 사용<br>
 * 방의 수를 얻기 (배열명.length)
 */
public class UseArray1 {
	
	/**
	 *  1차원 배열을 참조형 형식으로 사용
	 */
	public UseArray1() {
		// 1.배열 선언) 데이터형[] 배열명 = null;
		int[] arr = null;
		
		// 2.배열 생성) 배열명 = new 데이터형[방의갯수];
		arr = new int[6];
		System.out.println(arr);
		// 배열을 생성하면 모든 방의 값이 초기화가 된다.
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		// 선언과 생성을 동시에
		int[] arr1 = new int[8];
		System.out.println(arr1);

		System.out.println("arr배열 방의 갯수 "+arr.length
				+", arr1배열 방의 갯수 "+arr1.length);
		
		// 3.값 할당) 배열명[방의인덱스] = 값;
		arr[0] = 11;
		arr[1] = 27;
		arr[2] = 14;
		arr[3] = 46;
		
		// 4.값 얻기 (일괄처리)
		for(int i : arr) {
			System.out.print(i+" ");
		}
		for(int i=0; i<arr.length;i++) {
			System.out.println("arr["+i+"]="+arr[i]);
			System.out.printf("arr[%d]=%d \n",i,arr[i]);
		}
		System.out.println();
		// 배열에 없는 인덱스를 사용하면 error(ArrayIndexOutOfBoundsException)
		// System.out.println(arr[7]);
	}
	
	public static void main(String[] args) {
		new UseArray1();
	}
}
