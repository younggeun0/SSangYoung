package date181205;

public class UseLotto {

	public static void main(String[] args) {

		Lotto lotto = new Lotto();

		lotto.printBall(lotto.sortBall(lotto.pickBall(lotto.getBall())));

	}
}
