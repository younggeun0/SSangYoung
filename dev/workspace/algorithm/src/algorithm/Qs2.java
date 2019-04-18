package algorithm;

import java.util.Arrays;

public class Qs2 {
	
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		
		if (start < part2 - 1) {
			quickSort(arr, start, part2-1);
		}
		
		if (part2 < end) {
			quickSort(arr, part2, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end) /2 ];
		
		while(start <= end) {
			while(arr[start]<pivot) start++;
			while(arr[end]>pivot) end--;
			
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}
	
	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		System.out.println(Arrays.toString(arr));
		
		quickSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
