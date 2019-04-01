package ajax0401;

import java.util.Arrays;

public class WebMemberVO {
	private String id,pass,name,ssn,gender,birth,age,marriage,marriage_date,zipcode,
		addr1,addr2,greeting,ip_addr;	
	
	private String[] lang;
	
	public WebMemberVO(String id, String pass, String name, String ssn, String gender, String birth, String age,
			String marriage, String marriage_date, String zipcode, String addr1, String addr2, String greeting,
			String ip_addr, String[] lang) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.ssn = ssn;
		this.gender = gender;
		this.birth = birth;
		this.age = age;
		this.marriage = marriage;
		this.marriage_date = marriage_date;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.greeting = greeting;
		this.ip_addr = ip_addr;
		this.lang = lang;
	}	

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth() {
		return birth;
	}

	public String getAge() {
		return age;
	}

	public String getMarriage() {
		return marriage;
	}

	public String getMarriage_date() {
		return marriage_date;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public String getGreeting() {
		return greeting;
	}

	public String getIp_addr() {
		return ip_addr;
	}

	public String[] getLang() {
		return lang;
	}

	@Override
	public String toString() {
		return "WebMemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", ssn=" + ssn + ", gender=" + gender
				+ ", birth=" + birth + ", age=" + age + ", marriage=" + marriage + ", marriage_date=" + marriage_date
				+ ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", greeting=" + greeting
				+ ", ip_addr=" + ip_addr + ", lang=" + Arrays.toString(lang) + "]";
	}
}
