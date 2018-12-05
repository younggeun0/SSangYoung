package date181205;

public class UseLotto {

	public static void main(String[] args) {

		Lotto lotto = new Lotto();

		// 영근 ver.
		System.out.println("영근 ver.");
		lotto.printBall(lotto.sortBall(lotto.pickBall(lotto.getBall())));

		// 재찬 ver. 
		System.out.println("재찬 ver.");
		lotto.printBall(lotto.sortBall(lotto.pickBall2(lotto.getBall())));

		// 영민 ver.
		System.out.println("영민 ver.");
		lotto.printBall(lotto.sortBall(lotto.pickBall3(lotto.getBall())));
		
	}
}
