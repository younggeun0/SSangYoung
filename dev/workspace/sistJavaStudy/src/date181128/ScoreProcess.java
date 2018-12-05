package date181128;

/**
 * 4������ �л����� ����ó�� ���α׷�
 * @author owner
 */
public class ScoreProcess {

	public ScoreProcess() {
		String[] nameArr = { "������","���ü�","������","�����","������" };
		int[] scoreArr = { 89,76,99,64,50 };
		int totalScore = 0;	// ������ ������
		
		// �ִ밪 �ּҰ��� ������ ����, ù �ε��������� �ʱ�ȭ
		int highestScore = scoreArr[0];
		int lowestScore = scoreArr[0];
		
		System.out.println("��ȣ\t�̸�\t����");
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
		System.out.println("���� ���� �� ");
		System.out.println("-------------------------");
		for(int i=0; i<nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i+1, nameArr[i], scoreArr[i]);
			totalScore += scoreArr[i];
		}
		
		System.out.println("-------------------------");
		System.out.println("�����ο� : "+nameArr.length+"��");
		System.out.printf("����[%-5d] ���[%.2f]\n", totalScore, 
				totalScore/(float)nameArr.length);
		
		// casting���ϸ� ����� ������ ����
		System.out.println("���� ��հ� : " + totalScore/nameArr.length);
		
		System.out.printf("�ְ���[%d] ������[%d]\n", highestScore, lowestScore);
	}
	
	public static void main(String[] args) {
		new ScoreProcess();
	}
}
