package date181203;

import java.lang.reflect.Array;
import java.util.Arrays;

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
		
		System.out.println("-------------------------------------------");
		String[] clackLang = superman.language("�ܰ��");
		clackLang = superman.language("����");
		clackLang = superman.language("����");
		clackLang = superman.language("����");
		clackLang = superman.language("�ѱ���");
		System.out.println(Arrays.toString(clackLang));

		String[] hongLang = gd.language("�ѱ���");
		hongLang = gd.language("�߱���");
		hongLang = gd.language("��ȭ");
		System.out.println(Arrays.toString(hongLang));
		System.out.println("-------------------------------------------");
				
		gd.paint();
		superman.paint();
		System.out.println("-------------------------------------------");
		
		// Clark�� �������̽��� �����Ͽ����Ƿ� 
		System.out.println(superman.speed("1000"));
		System.out.println(superman.height("300"));
		
	}
}
