package date181123;

public class UseRamen {
	
	public static void main(String[] args) {
		
		Ramen Nyuguri = new Ramen();
		
		Nyuguri.setName("�ʱ���");
		Nyuguri.setPrice(800);
		Nyuguri.setSpicyLevel(2);
		Nyuguri.setSoupNum(2);
		Nyuguri.setNoodleLevel(2);
		
		System.out.printf("%s�� ������ %d���Դϴ�. ������ %d�� �ֽ��ϴ�.\n",
				Nyuguri.getName(), Nyuguri.getPrice(), Nyuguri.getSoupNum());
		
		System.out.println(Nyuguri.cooked());
		System.out.println(Nyuguri.cooked(450, "����","����","����","���尡��"));
		
		Ramen Ohjjam = new Ramen();
		
		Ohjjam.setName("��¡��«��");
		Ohjjam.setPrice(1000);
		Ohjjam.setSpicyLevel(4);
		Ohjjam.setSoupNum(2);
		Ohjjam.setNoodleLevel(1);
		
		System.out.printf("%s�� ������ %d���Դϴ�. ������ %d�� �ֽ��ϴ�.\n",
				Ohjjam.getName(), Ohjjam.getPrice(), Ohjjam.getSoupNum());
		
		System.out.println(Ohjjam.cooked());
		System.out.println(Ohjjam.cooked(600));
		
	}

}
