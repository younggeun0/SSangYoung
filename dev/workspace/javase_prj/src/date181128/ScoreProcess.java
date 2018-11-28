package date181128;

/**
 * 4강의장 학생들의 성적처리 프로그램
 * @author owner
 */
public class ScoreProcess {

	public ScoreProcess() {
		String[] nameArr = { "이재찬","정택성","이재현","김건하","공선의" };
		int[] scoreArr = { 89,76,99,64,50 };
		int totalScore = 0;	// 총점을 누적합
		
		// 최대값 최소값을 저장할 변수, 첫 인덱스값으로 초기화
		int highestScore = scoreArr[0];
		int lowestScore = scoreArr[0];
		
		System.out.println("번호\t이름\t점수");
		System.out.println("-------------------------");
	
		for(int i=0; i<nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i+1, nameArr[i], scoreArr[i]);
			totalScore += scoreArr[i];
			
			if (scoreArr[i] > highestScore)
				highestScore = scoreArr[i];
			if (scoreArr[i] < lowestScore) {
				lowestScore = scoreArr[i];
			}
		}
		
		int temp;
		String tmpStr;
		for(int i=0; i<scoreArr.length-1; i++) {
			
			for(int j=i+1; j<scoreArr.length; j++) {
				if (scoreArr[i] > scoreArr[j]) {
					temp = scoreArr[i];
					scoreArr[i] = scoreArr[j];
					scoreArr[j] = temp;
					
					tmpStr = nameArr[i];
					nameArr[i] = nameArr[j];
					nameArr[j] = tmpStr;
				}
			}
		}
		
		System.out.println("-------------------------");
		System.out.println("선택 정렬 후 ");
		System.out.println("-------------------------");
		for(int i=0; i<nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i+1, nameArr[i], scoreArr[i]);
			totalScore += scoreArr[i];
		}
		
		System.out.println("-------------------------");
		System.out.println("응시인원 : "+nameArr.length+"명");
		System.out.printf("총점[%-5d] 평균[%.2f]\n", totalScore, 
				totalScore/(float)nameArr.length);
		
		// casting안하면 결과는 정수가 나옴
		System.out.println("정수 평균값 : " + totalScore/nameArr.length);
		
		System.out.printf("최고점[%d] 최저점[%d]\n", highestScore, lowestScore);
	}
	
	public static void main(String[] args) {
		new ScoreProcess();
	}
}
