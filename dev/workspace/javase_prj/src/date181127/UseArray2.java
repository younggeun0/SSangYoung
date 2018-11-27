package date181127;

public class UseArray2 {

	/**
	 * 1차원 배열을 기본형 형식으로 사용
	 */
	public void arrayPrimitive() {
		
		// 1.선언) 데이터형[] 배열명 = {값,값, ... };
		System.out.println("기본형 형식의 사용");
		int[] arr = { 2018, 11, 27, 15, 20 };
		
		System.out.println("arr 방의 수 "+arr.length);
		
		// 방의 갯수를 정의하면 error
		// int[] arr1 = new int[6] { 1,2,3,4,5,6,7 };
		int[] arr1 = new int[] { 1,2,3,4,5,6,7 };
		System.out.println("arr1 방의 수 "+arr1.length);

		arr[0]=2019;
		
		// 향상된 for : 배열이나 Collection(List, Set)의 처음 방부터 끝방까지 
		// 모든방의 값을 순차적으로 손쉽게 출력할 때 사용
		/*
		 * for(배열의 값을 저장할 변수 : 배열) {
		 *	 변수명
		 * }
		 */
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		// arr1배열의 마지막방부터 처음 방까지 출력
		for(int i=arr1.length-1; i>-1; i--) {
			System.out.printf(arr1[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new UseArray2().arrayPrimitive();
	}
}
