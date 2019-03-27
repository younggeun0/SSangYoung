package date0327;

public class DataVO {

	private String carModel, company, owner, carType; // carType을 속성으로 줄 것
	private int cc;

	public DataVO() {
	}
	
	public DataVO(String carModel, String company, String owner, String carType, int cc) {
		this.carModel = carModel;
		this.company = company;
		this.owner = owner;
		this.carType = carType;
		this.cc = cc;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "DataVO [carModel=" + carModel + ", company=" + company + ", owner=" + owner + ", carType=" + carType
				+ ", cc=" + cc + "]";
	}
}
