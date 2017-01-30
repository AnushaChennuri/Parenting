package com.web.parenting.model;

public class AddressVO {
 
	private String address_id;
	private String address;
	private String address2;
	private String district;
	private String city;
	private String postal_code;
	private String state;
	private String country;
	private String location;
	
	public AddressVO() {
		super();
	}
	
	public AddressVO(String address_id, String address, String address2, String district, String city,
			String postal_code, String state, String country, String location) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city = city;
		this.postal_code = postal_code;
		this.state = state;
		this.country = country;
		this.location = location;
	}

	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
