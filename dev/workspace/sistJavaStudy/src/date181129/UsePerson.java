package date181129;

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
	}
}
