/*
	Constant(������ ���ó�� ����ϴ� ��: ���)�� ���
	���� : class field������ ����
*/
class Constant {

	// Constant ����
	// ����� method������ ������ �� ����
	public static final int MAX_SCORE=100;
	public static final int MIN_SCORE=0;

	public static void main(String[] args) {
		
		// ����� ���
		System.out.println(MAX_SCORE + " / " + MIN_SCORE);	
		System.out.println(Constant.MAX_SCORE + " / " + Constant.MIN_SCORE);

		int my_score=83;
		// MAX_SCORE=90; ����� ���Ҵ��� ���� �ʴ´�.

		System.out.println("������ �ְ����� "+Constant.MAX_SCORE+
			"���̰�, �������� :"+Constant.MIN_SCORE+"�Դϴ�. ȹ�������� "
			+my_score+"�̰�, �ְ����� ȹ�������� ���̴� "+
				(MAX_SCORE-my_score)+"�Դϴ�.");
		
		// Ŭ���� field ����غ���
		System.out.println("long�� �ִ� : "+Long.MAX_VALUE 
			+", long�� �ּҰ� : "+Long.MIN_VALUE);
		// �� �ܿ�� java api doc ã���鼭 ���


	}// main
}// class
