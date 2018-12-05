package date181120;

/**
 * 개선된 for문 : 배열이나 Collection들의 모든 요소의 값을<br>
 * 				  처음부터 끝까지 순차적으로 출력하기 위해 제공<br>
 * 
 * 문법) for(데이터형 변수: 배열명(Collection명)) {<br>
 * 			변수명;(배열(Collection)요소의 값을 사용할 수 있다.)<br>	
 * 		 }
 * 
 * @author owner
 */
public class EnhancedFor02 {

	public static void main(String[] args) {
		
		int[] tempArr = {2018, 11, 20, 16, 5};
		
		// 기존의 for로 모든 요소의 값을 출력
		for(int i=0;i<tempArr.length;i++) {
			System.out.println(tempArr[i]);
		}
		
		System.out.println("------ 개선된 for -------");
		
		// 향상된 for로 모든 요소의 값을 출력
		for(int i:tempArr) {
			System.out.println(i);
		}
		
	}
}
