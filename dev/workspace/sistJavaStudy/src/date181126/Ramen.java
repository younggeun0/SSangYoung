package date181126;

public class Ramen {

	private String name;
	private int price;
	
	// ���� �⺻ ������ �����
	public Ramen() {
		this("���� ���",0);
	}
	// �����ִ� ������ �����
	public Ramen(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	public void cook() {
		System.out.printf("%d��¥�� %s ����� �����մϴ�.", price, name);
		System.out.println();
	}
}
