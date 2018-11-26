package date181126;

public class UseRamen {

	public static void main(String[] args) {
		
		Ramen sin = new Ramen();
		
		sin.setName("신라면");
		sin.setPrice(1500);
		
		sin.cook();
		
		System.out.println(sin.getName() +" 라면은 "+sin.getPrice()+"원입니다.");
		
		Ramen sinBlack = new Ramen();
		
		sinBlack.setName("신라면 블랙");
		sinBlack.setPrice(3000);
		
		sinBlack.cook();
		System.out.println(sinBlack.getName()+" 라면은 "+sinBlack.getPrice()+"원입니다.");
		
		// 숙제
		Ramen ohjjam = new Ramen();
		System.out.println(ohjjam.getName()+" 라면은 "+ohjjam.getPrice()+"원입니다.");
		
		Ramen chamkke = new Ramen("참께라면", 1500);
		System.out.println(chamkke.getName()+" 라면은 "+chamkke.getPrice()+"원입니다.");
	}
}
