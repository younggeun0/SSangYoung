package date0327;

public class AttrVO {
	
	private String firstName, lastName, city, zipcode, address;

	public AttrVO() {
	}
	
	public AttrVO(String firstName, String lastName, String city, String zipcode, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.zipcode = zipcode;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AttrVO [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", zipcode=" + zipcode
				+ ", address=" + address + "]";
	}
}
