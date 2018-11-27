package date181127;

public class UseArray2 {

	/**
	 * 1���� �迭�� �⺻�� �������� ���
	 */
	public void arrayPrimitive() {
		
		// 1.����) ��������[] �迭�� = {��,��, ... };
		System.out.println("�⺻�� ������ ���");
		int[] arr = { 2018, 11, 27, 15, 20 };
		
		System.out.println("arr ���� �� "+arr.length);
		
		// ���� ������ �����ϸ� error
		// int[] arr1 = new int[6] { 1,2,3,4,5,6,7 };
		int[] arr1 = new int[] { 1,2,3,4,5,6,7 };
		System.out.println("arr1 ���� �� "+arr1.length);

		arr[0]=2019;
		
		// ���� for : �迭�̳� Collection(List, Set)�� ó�� ����� ������� 
		// ������ ���� ���������� �ս��� ����� �� ���
		/*
		 * for(�迭�� ���� ������ ���� : �迭) {
		 *	 ������
		 * }
		 */
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		// arr1�迭�� ����������� ó�� ����� ���
		for(int i=arr1.length-1; i>-1; i--) {
			System.out.printf(arr1[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new UseArray2().arrayPrimitive();
	}
}
