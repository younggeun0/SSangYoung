package date181205;

public class UseLotto {

	public static void main(String[] args) {

		Lotto lotto = new Lotto();

		// ���� ver.
		System.out.println("���� ver.");
		lotto.printBall(lotto.sortBall(lotto.pickBall(lotto.getBall())));

		// ���� ver. 
		System.out.println("���� ver.");
		lotto.printBall(lotto.sortBall(lotto.pickBall2(lotto.getBall())));

		// ���� ver.
		System.out.println("���� ver.");
		lotto.printBall(lotto.sortBall(lotto.pickBall3(lotto.getBall())));
		
	}
}
