package date181128;

public class Zodiac {

	public static void main(String[] args) {
		
		int yearOfBirth = 1990;
		
		String[] zodiac = {"������","��","��","����","��",
			"��","ȣ����","�䳢","��","��","��","��"};
		
		System.out.println(zodiac[yearOfBirth%12]);
		
	}
}
