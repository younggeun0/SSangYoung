package date0313;

public class TestVO {
	private String firstName;
	private int age;
	
	public TestVO() {
		System.out.println("TestVO의 기본 생성자");
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
