package date181123;

public class UseRamen {
	
	public static void main(String[] args) {
		
		Ramen Nyuguri = new Ramen();
		
		Nyuguri.setName("너구리");
		Nyuguri.setPrice(800);
		Nyuguri.setSpicyLevel(2);
		Nyuguri.setSoupNum(2);
		Nyuguri.setNoodleLevel(2);
		
		System.out.printf("%s의 가격은 %d원입니다. 스프는 %d개 있습니다.\n",
				Nyuguri.getName(), Nyuguri.getPrice(), Nyuguri.getSoupNum());
		
		System.out.println(Nyuguri.cooked());
		System.out.println(Nyuguri.cooked(450, "육전","버섯","대파","고춧가루"));
		
		Ramen Ohjjam = new Ramen();
		
		Ohjjam.setName("오징어짬뽕");
		Ohjjam.setPrice(1000);
		Ohjjam.setSpicyLevel(4);
		Ohjjam.setSoupNum(2);
		Ohjjam.setNoodleLevel(1);
		
		System.out.printf("%s의 가격은 %d원입니다. 스프는 %d개 있습니다.\n",
				Ohjjam.getName(), Ohjjam.getPrice(), Ohjjam.getSoupNum());
		
		System.out.println(Ohjjam.cooked());
		System.out.println(Ohjjam.cooked(600));
		
	}

}
