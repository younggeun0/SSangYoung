package date181221;

import java.io.Serializable;

/**
 * �����͸� ������ �ִ� ����ȭ ��� Ŭ����
 * @author owner
 */
@SuppressWarnings("serial")
public class UserData implements Serializable {
	
	private int age;
	// transient : ����ȭ�� ���� Ű����(���� JVM �ܺη� ���޵��� �ʴ´�.)
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
