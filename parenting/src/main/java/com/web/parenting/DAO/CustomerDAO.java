package com.web.parenting.DAO;

import com.web.parenting.model.CustomerDetailVO;
import com.web.parenting.model.CustomerVO;

public interface CustomerDAO {
	
	public CustomerVO isCustomerExsist(CustomerVO customer);
	
	public CustomerVO insertNewCustomer(CustomerDetailVO customerDetailVO);

}
