package date181126;

public class UseRamen {

	public static void main(String[] args) {
		
		Ramen sin = new Ramen();
		
		sin.setName("�Ŷ��");
		sin.setPrice(1500);
		
		sin.cook();
		
		System.out.println(sin.getName() +" ����� "+sin.getPrice()+"���Դϴ�.");
		
		Ramen sinBlack = new Ramen();
		
		sinBlack.setName("�Ŷ�� ��");
		sinBlack.setPrice(3000);
		
		sinBlack.cook();
		System.out.println(sinBlack.getName()+" ����� "+sinBlack.getPrice()+"���Դϴ�.");
		
		// ����
		Ramen ohjjam = new Ramen();
		System.out.println(ohjjam.getName()+" ����� "+ohjjam.getPrice()+"���Դϴ�.");
		
		Ramen chamkke = new Ramen("�������", 1500);
		System.out.println(chamkke.getName()+" ����� "+chamkke.getPrice()+"���Դϴ�.");
	}
}
