package date181221;

import java.io.Serializable;

/**
 * 데이터를 가지고 있는 직렬화 대상 클래스
 * @author owner
 */
@SuppressWarnings("serial")
public class UserData implements Serializable {
	
	private int age;
	// transient : 직렬화를 막는 키워드(값이 JVM 외부로 전달되지 않는다.)
	private /*transient*/ double weight;
	private /*transient*/ String name;
	
	
	public UserData() {
		
	}
	public UserData(int age, double weight, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "UserData [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}
}
