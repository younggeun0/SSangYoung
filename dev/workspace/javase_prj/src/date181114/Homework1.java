package date181114;

/*
1. 아래의 값을 저장할 변수를 만들고 출력해 보세요.
   이니셜 : 'K', 나이 : 자신의나이, 왼눈시력 : 1.5, 오른눈 시력 : 0.8
   출력 : 나의 이니셜은 'K'이고, xx살입니다. 시력은 왼눈 xx, 오른눈 xx입니다.

*/
class Homework1
{
	public static void main(String[] args) 
	{
		char initial = 'O';
		int age = 29;
		float leftEye = 1.2f;
		double rightEye = 1.0;

		System.out.println("나의 이니셜은 "+initial+
			"이고, "+age+"살입니다. 시력은 왼눈 "+
			leftEye+", 오른눈 "+rightEye+"입니다.");

	}
}
