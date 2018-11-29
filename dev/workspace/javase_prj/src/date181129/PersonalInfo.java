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

	// 1. 배열에 입력하는 method를 작성할것.
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
