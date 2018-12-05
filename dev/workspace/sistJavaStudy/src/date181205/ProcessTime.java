package date181205;

public class ProcessTime {

	public static void main(String[] args) {

		// 프로그램 평균시간 구하기
		long[] processTime = new long[17];
		long st = 0, et = 0;
		long sumTime = 0;
		long avgTime = 0;

		for (int i = 0; i < processTime.length; i++) {
			st = System.currentTimeMillis();

			for (int j = 0; j < 50000; j++) {
				System.out.print(j);
			}
			System.out.println();

			et = System.currentTimeMillis();
			processTime[i] = (et - st);
			sumTime += processTime[i];
		}

		avgTime = sumTime / processTime.length;
		System.out.println("소요되는 평균시간(ms) : " + avgTime);
	}
}