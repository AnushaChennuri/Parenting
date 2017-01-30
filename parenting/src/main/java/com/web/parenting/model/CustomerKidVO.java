package com.web.parenting.model;


public class CustomerKidVO {
	
	private String cust_Kid_Nm;
	private String cust_Kid_Age;
	private String cust_Kid_Gender;
	private String cust_Kid_Grade;
	private String cust_Kid_School;
	private String cust_Kid_Location;
	
	public CustomerKidVO() {
		super();
	}
	public CustomerKidVO(String cust_Kid_Nm, String cust_Kid_Age, String cust_Kid_Gender, String cust_Kid_Grade,
			String cust_Kid_School, String cust_Kid_Location) {
		super();
		this.cust_Kid_Nm = cust_Kid_Nm;
		this.cust_Kid_Age = cust_Kid_Age;
		this.cust_Kid_Gender = cust_Kid_Gender;
		this.cust_Kid_Grade = cust_Kid_Grade;
		this.cust_Kid_School = cust_Kid_School;
		this.cust_Kid_Location = cust_Kid_Location;
	}
	public String getCust_Kid_Nm() {
		return cust_Kid_Nm;
	}
	public void setCust_Kid_Nm(String cust_Kid_Nm) {
		this.cust_Kid_Nm = cust_Kid_Nm;
	}
	public String getCust_Kid_Age() {
		return cust_Kid_Age;
	}
	public void setCust_Kid_Age(String cust_Kid_Age) {
		this.cust_Kid_Age = cust_Kid_Age;
	}
	public String getCust_Kid_Gender() {
		return cust_Kid_Gender;
	}
	public void setCust_Kid_Gender(String cust_Kid_Gender) {
		this.cust_Kid_Gender = cust_Kid_Gender;
	}
	public String getCust_Kid_Grade() {
		return cust_Kid_Grade;
	}
	public void setCust_Kid_Grade(String cust_Kid_Grade) {
		this.cust_Kid_Grade = cust_Kid_Grade;
	}
	public String getCust_Kid_School() {
		return cust_Kid_School;
	}
	public void setCust_Kid_School(String cust_Kid_School) {
		this.cust_Kid_School = cust_Kid_School;
	}
	public String getCust_Kid_Location() {
		return cust_Kid_Location;
	}
	public void setCust_Kid_Location(String cust_Kid_Location) {
		this.cust_Kid_Location = cust_Kid_Location;
	}
	
	

}
