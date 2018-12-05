package date181129;

/**
 * 이름, 나이, 이메일, 성의 이니셜 한자를 저장하는 클래스
 * @author owner
 */
public class Data {
	
	private String name;
	private int age;
	private String email;
	private char initial;
	
	public Data() {
		System.out.println("Data Default Constructor");
	}
	
	public Data(String name, int age, String email, char initial) {
		System.out.println("Data Constructor");
		this.name = name;
		this.age = age;
		this.email = email;
		this.initial = initial;
	}
	
	public String toString() {
		return "이름 : "+name+", 나이 : "+age
				+", 이메일 : "+email+", 이니셜 : "+initial;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setInitial(char initial) {
		this.initial = initial;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public char getInitial() {
		return initial;
	}
}
