package algorithm;

public class Qs1 {
	
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		
		if (start < part2 - 1) { // 왼쪽 파티션의 데이터가 하나 이상일 때
			quickSort(arr, start, part2-1);
		}
		
		if (part2 < end) { // 오른쪽 파티션의 시작점이 마지막 배열방보다 작은 경우만 정렬
			quickSort(arr, part2, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		
		while(start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start; // 새로 나눈 오른쪽 파티션의 오른쪽 인덱스를 반환
	}
	
	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	private static void printArray(int[] arr) {
		for(int data: arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		
		quickSort(arr);
		
		printArray(arr);
	}
}
