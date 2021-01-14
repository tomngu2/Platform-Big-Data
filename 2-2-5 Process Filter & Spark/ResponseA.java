package com.sparkTutorial.rdd;

public class ResponseA {
	private int branch_code;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String last_updated;
	
	public ResponseA(int branch_code, String name, String street, String city, String state, String zip, String phone,
			String last_updated) {
		super();
		this.branch_code = branch_code;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.last_updated = last_updated;
	}

	public int getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	@Override
	public String toString() {
		return "ResponseA [branch_code=" + branch_code + ", name=" + name + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", last_updated=" + last_updated + "]";
	}
	
	
	
	
	
	
	
	
	
}
