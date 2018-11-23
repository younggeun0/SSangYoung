package date181123;

public class Ramen {

	// ����� Ư¡
	private String name;
	private int price;
	private int spicyLevel; 	// �ſ��  0:�ȸſ�, 1:���ݸſ� 2:�߰��ſ� 3:�ſ�ſ�
	private int soupNum;		// ���� ����
	private int noodleLevel;	// �� �β� 0:����, 1:���� 2:�β���
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		if (price < 0 || price > 10000) {
			System.out.println("�߸��� �����Դϴ�.");
		} else {
			this.price = price;
		}
	}
	public void setSpicyLevel(int spicyLevel) {
		if (spicyLevel < 4 || spicyLevel >= 0) {
			this.spicyLevel = spicyLevel;
		} else {
			System.out.println("�ſ������� 0~3���� �ֽ��ϴ�.");
			System.out.println("0:�ȸſ�, 1:���ݸſ� 2:�߰��ſ� 3:�ſ�ſ�");
		}
	}
	public void setSoupNum(int soupNum) {
		if (soupNum > 4) {
			System.out.println("���� ������ 5�� �̻����� �ʹ� �����ϴ�.");
			this.soupNum = 3;
		} else if (soupNum < 0){
			System.out.println("������ 0������ ���� �� �����ϴ�.");
			this.soupNum = 0;
		} else {
			this.soupNum = soupNum;
		}
	}
	public void setNoodleLevel(int noodleLevel) {
		if (noodleLevel < 3 || noodleLevel >= 0) {
			this.noodleLevel = noodleLevel;
		} else {
			System.out.println("���� �β��� 0~3���� �ֽ��ϴ�.");
			System.out.println("0:����, 1:���� 2:�β���");
		}
	}
	
	// getter
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getSpicyLevel() {
		return spicyLevel;
	}
	public int getSoupNum() {
		return soupNum;
	}
	public int getNoodleLevel() {
		return noodleLevel;
	}
	
	// ������ Ư¡
	public String Cooked() {
		// ������ �����ϱ�
		String msg = name+" ����� "+checkSpicy()+"������ �ſ�ܰ踦 ���� \n"
				+ "��� �β��� "+checkNoodle()+"�Դϴ�.\n";
		
		return msg+" ����� ���� ���� �Ա����� �ѽʴϴ�.";
	}
	public String Cooked(int water, String... ingredients) {
		// ����ְ� �����ϱ�
		String msg;
		
		msg = name+" ����� "+checkSpicy()+"������ �ſ�ܰ踦 ���� \n"
				+ "��� �β��� "+checkNoodle()+"�Դϴ�.\n";
		
		for (String ingredient : ingredients) {
			msg += ingredient+", ";
		}
		
		if (water > 500) {
			msg += "�� "+water+"ml��ŭ �ְ� �����մϴ�.\n"
					+ "���� ���� �̰ſ�� �����ϴ�..";
			
			return msg;
		} else if (water <= 500 || water >= 300) {

			msg += "�� "+water+"ml��ŭ �ְ� �����մϴ�.\n"
					+ "���� ������ �� �����ϴ�!";
			return msg;
			
		} else {
			msg += "�� "+water+"ml��ŭ �ְ� �����մϴ�.\n"
					+ "���� ���� © �� �����ϴ�..";
			return msg;
		}
	}
	
	// �ſ������� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	private String checkSpicy() {
		// �ſ��  0:�ȸſ�, 1:���ݸſ� 2:�߰��ſ� 3:�ſ�ſ�
		switch(this.spicyLevel) {
		case 1:
			return "���ݸſ�";
		case 2:
			return "�߰��ſ�";
		case 3:
			return "�ſ�ſ�";
		default:
			return "�ȸſ�";
		}
	}
	
	// ��β��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	private String checkNoodle() {
		// �� �β� 0:����, 1:���� 2:�β���
		switch(this.noodleLevel) {
		case 0:
			return "����";
		case 2:
			return "�β���";
		default :
			return "����";
		}
	}
}
