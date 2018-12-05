package date181129;

public class UsePerson {
	
	public static void main(String[] args) {
		
		HongGilDong gd = new HongGilDong();
		
		gd.setName("홍길동");			// 부모클래스의 메소드 사용
		System.out.println("눈 "+gd.getEye()+", 코 "
				+gd.getNose()+", 입 "+gd.getMouth());
		System.out.println(gd.eat());	
		
		System.out.println(gd.eat("국밥",1));
		
		// 자신만의 특징
		System.out.println(gd.fight(6)); 	// 7>6
		System.out.println(gd.fight(4)); 	// 8>4
		System.out.println(gd.fight(10)); 	// 9<10
		System.out.println(gd.fight(10)); 	// 8<10
		System.out.println(gd.fight(7));	// 7==7
	}
}
