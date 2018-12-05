package date181119;

public class TestElseIf3 {

	public static void main(String[] args) {
		
		//ÅÂ¾î³­ÇØ¸¦ ÀÔ·Â¹Þ¾Æ ¶ì(12) ±¸ÇÏ±â
		//11-¾ç, 10-¸», 9-¹ì, 8-¿ë, 7-Åä³¢, 6-È£¶ûÀÌ, 5-¼Ò, 4-Áã, 3-µÅÁö,
		//2-°³, 1-´ß, 0-¿ø¼þÀÌ
		int input = Integer.parseInt(args[0]);
		
		if (input%12 == 11) {
			System.out.println("¾ç");
		} else if (input%12 == 10) {
			System.out.println("¸»");
		} else if (input%12 == 9) {
			System.out.println("¹ì");
		} else if (input%12 == 8) {
			System.out.println("¿ë");
		} else if (input%12 == 7) {
			System.out.println("Åä³¢");
		} else if (input%12 == 6) {
			System.out.println("È£¶ûÀÌ");
		} else if (input%12 == 5) {
			System.out.println("¼Ò");
		} else if (input%12 == 4) {
			System.out.println("Áã");
		} else if (input%12 == 3) {
			System.out.println("µÅÁö");
		} else if (input%12 == 2) {
			System.out.println("°³");
		} else if (input%12 == 1) {
			System.out.println("´ß");
		} else {
			System.out.println("¿ø¼þÀÌ");
		}
		
	}
}
