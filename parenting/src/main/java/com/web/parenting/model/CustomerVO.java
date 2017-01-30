package com.web.parenting.model;

public class CustomerVO {
	
	private Integer custId;
	
	private String custEmail;
	
	private String custPassword;
	
	private String  custTelephone;
	
	public CustomerVO(Integer custId, String custEmail, String custPassword, String custTelephone) {
		super();
		this.custId = custId;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custTelephone = custTelephone;
	}
	
	

	public CustomerVO() {
		super();
		
	}



	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustTelephone() {
		return custTelephone;
	}

	public void setCustTelephone(String custTelephone) {
		this.custTelephone = custTelephone;
	}
	
	

}
