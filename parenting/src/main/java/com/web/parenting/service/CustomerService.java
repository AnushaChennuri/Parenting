package com.web.parenting.service;

import com.web.parenting.model.CustomerDetailVO;
import com.web.parenting.model.CustomerVO;

public interface CustomerService {
	
	public CustomerVO isCustomerExsist(CustomerVO customer);	
	public CustomerVO insertNewCustomer(CustomerDetailVO customerDetailVO);

}
