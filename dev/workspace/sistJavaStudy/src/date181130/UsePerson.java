package date181130;

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
		
		// 자식이 생성되면 부모클래스가 먼저 생성된 후 자식이 생성됨
		Clark superman = new Clark();
		// 자식의 객체로 부모클래스의 자원(변수, method)를 
		// 자식의 것처럼 사용할 수 있다.
		// 코드의 재사용성!
		superman.setName("클라크");
		System.out.println("이름 "+superman.getName()+", 눈 "
				+superman.getEye()+", 코 "
				+superman.getNose()+", 입 "+superman.getMouth());
		
		System.out.println(superman.eat());
		System.out.println(superman.eat("steak",10));
		
		// 자식의 method
		String stone = "짱돌";
		System.out.println(stone+"을 맞은 결과 "
				+superman.power(stone)+", 힘의 변화 : "
				+superman.power);
		
		
		stone = "크립토나이트";
		System.out.println(stone+"을 맞은 결과 "
				+superman.power(stone)+", 힘의 변화 : "
				+superman.power);
		
		stone = "다이아몬드";
		System.out.println(stone+"을 맞은 결과 "
				+superman.power(stone)+", 힘의 변화 : "
				+superman.power);
		
		
		// 자신 클래스
		Young oh = new Young();
		System.out.println(oh.getName());
		System.out.println("이름 "+oh.getName()+", 눈 "
				+oh.getEye()+", 코 "
				+oh.getNose()+", 입 "
				+oh.getMouth());
		
		System.out.println(oh.coding());
		System.out.println(oh.idle());
		System.out.println(oh.eat());
		
		for(int i =0; i<8; i++ ) {
			System.out.printf("질문의 수 %d개일때 대답 %s\n",i,oh.beAsked(i));
		}
		
	}
}
