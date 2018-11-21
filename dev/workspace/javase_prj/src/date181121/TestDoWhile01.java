package date181121;

/**
 * do~while : 시작과 끝을 모를 때 사용하는 반복문<br>
 * 최소 1번 수행 최대 조건까지 수행<br>
 * 문법) do{ <br>
 * 반복수행문장들;<br>
 * }while(조건식);
 * 
 * @author owner
 */
public class TestDoWhile01 {

	public static void main(String[] args) {
		int i = 1000;// 초기값
		do {
			System.out.println("i=" + i);// 반복수행문장
			i++;// 증가식
		} while (i < 10);// 조건식
	}// main
}// class
