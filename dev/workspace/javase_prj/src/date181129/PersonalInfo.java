/*
���� 1.
��ȣ,�̸�,�ּ�,����,������  ������ �� �ִ� Ŭ������ ����� 
�Ʒ��� ���� ���� �Է��մϴ�.

�Է°�
1, ������, ����� ������ ���ﵿ, 28,����
2, ������, ����� ���빮�� ��ʸ���, 27,����
3, ������, ������ ���뱸 ���뵿, 26,����
4, ���ü�, ����� ���α� ���ε�,27, ����
5, ���ü�, ����� ���۱� �󵵵�,29,����
6, �����, ��⵵ ��õ�� ��õ��,26,����
7, �����, ����� ������ �����絿,27,����
 ����� ������ x��
 ���� �� x��
 �ְ���� "���ü�(����)"
 
1. ���ǰ��� �迭�� �Է��ϴ� method�� �ۼ��Ұ�.
2. �迭�� �Էµ� ���� ����ϴ� method �� �ۼ��Ұ�.
   2�� method ���� ����ÿ� ��� �ִ� �ο����� ��� �Ұ�.
   2�� method ���� ������ ���� ��� �Ұ�.
   2�� method ���� ���� ���̰� ���� ����� �̸��� ��� �� ��.
 */
package date181129;

public class PersonalInfo {
	private int num;
	private String name;
	private String address;
	private int age;
	private String gender;
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}

	// 1. �迭�� �Է��ϴ� method�� �ۼ��Ұ�.
	public void setAllInfo(int num, String name, String address, int age, String gender) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
	}
	
	// 2.
	public void printPersonalInfo() {
		System.out.printf("%d, %s, %s, %d, %s\n",
				getNum(), getName(), 
				getAddress(), getAge(),
				getGender());
	}
}
