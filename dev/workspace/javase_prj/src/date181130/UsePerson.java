package date181130;

public class UsePerson {
	
	public static void main(String[] args) {
		
		HongGilDong gd = new HongGilDong();
		
		gd.setName("ȫ�浿");			// �θ�Ŭ������ �޼ҵ� ���
		System.out.println("�� "+gd.getEye()+", �� "
				+gd.getNose()+", �� "+gd.getMouth());
		System.out.println(gd.eat());	
		
		System.out.println(gd.eat("����",1));
		
		// �ڽŸ��� Ư¡
		System.out.println(gd.fight(6)); 	// 7>6
		System.out.println(gd.fight(4)); 	// 8>4
		System.out.println(gd.fight(10)); 	// 9<10
		System.out.println(gd.fight(10)); 	// 8<10
		System.out.println(gd.fight(7));	// 7==7
		
		// �ڽ��� �����Ǹ� �θ�Ŭ������ ���� ������ �� �ڽ��� ������
		Clark superman = new Clark();
		// �ڽ��� ��ü�� �θ�Ŭ������ �ڿ�(����, method)�� 
		// �ڽ��� ��ó�� ����� �� �ִ�.
		// �ڵ��� ���뼺!
		superman.setName("Ŭ��ũ");
		System.out.println("�̸� "+superman.getName()+", �� "
				+superman.getEye()+", �� "
				+superman.getNose()+", �� "+superman.getMouth());
		
		System.out.println(superman.eat());
		System.out.println(superman.eat("steak",10));
		
		// �ڽ��� method
		String stone = "¯��";
		System.out.println(stone+"�� ���� ��� "
				+superman.power(stone)+", ���� ��ȭ : "
				+superman.power);
		
		
		stone = "ũ���䳪��Ʈ";
		System.out.println(stone+"�� ���� ��� "
				+superman.power(stone)+", ���� ��ȭ : "
				+superman.power);
		
		stone = "���̾Ƹ��";
		System.out.println(stone+"�� ���� ��� "
				+superman.power(stone)+", ���� ��ȭ : "
				+superman.power);
		
		
		// �ڽ� Ŭ����
		Young oh = new Young();
		System.out.println(oh.getName());
		System.out.println("�̸� "+oh.getName()+", �� "
				+oh.getEye()+", �� "
				+oh.getNose()+", �� "
				+oh.getMouth());
		
		System.out.println(oh.coding());
		System.out.println(oh.idle());
		System.out.println(oh.eat());
		
		for(int i =0; i<8; i++ ) {
			System.out.printf("������ �� %d���϶� ��� %s\n",i,oh.beAsked(i));
		}
		
	}
}
