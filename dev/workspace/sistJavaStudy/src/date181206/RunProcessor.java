package date181206;

import java.util.Random;

public class RunProcessor {

	public static void main(String[] args) {
		
		String str = "������,�̺���,������,���ü�,������,������";
		
		ScoreProcessor sp = new ScoreProcessor(str);
		int cnt = 0; // ����� ��� �� (�����ϰ� 2~)
		
		while(true) {
			cnt = (int)(Math.random()*sp.name.size())+1;
			if (cnt > 1) break;
		}
		
		sp.printScore(cnt);
	}
}
