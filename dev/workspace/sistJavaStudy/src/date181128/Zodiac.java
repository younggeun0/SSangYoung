package date181128;

public class Zodiac {

	public static void main(String[] args) {
		
		int yearOfBirth = 1990;
		
		String[] zodiac = {"¿ø¼şÀÌ","´ß","°³","µÅÁö","Áã",
			"¼Ò","È£¶ûÀÌ","Åä³¢","¿ë","¹ì","¸»","¾ç"};
		
		System.out.println(zodiac[yearOfBirth%12]);
		
	}
}
