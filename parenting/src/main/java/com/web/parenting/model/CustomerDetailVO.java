package com.web.parenting.model;

import java.util.List;

import org.springframework.util.AutoPopulatingList;

public class CustomerDetailVO {
	
	private CustomerVO customerVO = new CustomerVO();
	private AddressVO addressVO= new AddressVO();
	private String custName;
	private String custGender;
	private String custSpouse;
	private String custNoKids;
	private AutoPopulatingList<CustomerKidVO> customerKidsList= new AutoPopulatingList<CustomerKidVO>(CustomerKidVO.class);

	public CustomerDetailVO() {
		super();
	}


	public CustomerDetailVO(CustomerVO customerVO, AddressVO addressVO, String custName, String custGender,
			String custSpouse, String custNoKids, AutoPopulatingList<CustomerKidVO> customerKidsList) {
		super();
		this.customerVO = customerVO;
		this.addressVO = addressVO;
		this.custName = custName;
		this.custGender = custGender;
		this.custSpouse = custSpouse;
		this.custNoKids = custNoKids;
		this.customerKidsList = customerKidsList;
	}


	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO custVO) {
		this.customerVO = custVO;
	}



	public AddressVO getAddressVO() {
		return addressVO;
	}



	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}



	public String getCustName() {
		return custName;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getCustGender() {
		return custGender;
	}



	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}



	public String getCustSpouse() {
		return custSpouse;
	}



	public void setCustSpouse(String custSpouse) {
		this.custSpouse = custSpouse;
	}



	public String getCustNoKids() {
		return custNoKids;
	}



	public void setCustNoKids(String custNoKids) {
		this.custNoKids = custNoKids;
	}


	public AutoPopulatingList<CustomerKidVO> getCustomerKidsList() {
		return customerKidsList;
	}


	public void setCustomerKidsList(AutoPopulatingList<CustomerKidVO> customerKidsList) {
		this.customerKidsList = customerKidsList;
	}
	
	
	

}
