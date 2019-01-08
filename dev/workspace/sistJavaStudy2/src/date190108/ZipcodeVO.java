package date190108;

public class ZipcodeVO {
	private String zipcode, sido, gugun, dong, bunji;

	public ZipcodeVO() {
		
	}
	
	public ZipcodeVO(String zipcode, String sido, String gugun, String dong, String bunji) {
		super();
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
	}

	public String getZipcode() {
		return zipcode;
	}
	public String getSido() {
		return sido;
	}
	public String getGugun() {
		return gugun;
	}
	public String getDong() {
		return dong;
	}
	public String getBunji() {
		return bunji;
	}	
}
