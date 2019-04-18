package kr.co.sist.vo;

import java.util.Arrays;

public class ParamVO {
	
	private String name;
	private int age;
	private String[] lang;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getLang() {
		return lang;
	}
	public void setLang(String[] lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "ParamVO [name=" + name + ", age=" + age + ", lang=" + Arrays.toString(lang) + "]";
	}
}
