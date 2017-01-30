package com.web.parenting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.parenting.DAO.CustomerDAO;
import com.web.parenting.DAO.CustomerDAOImpl;
import com.web.parenting.model.CustomerDetailVO;
import com.web.parenting.model.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAOImpl custDAO;//todo anusha auto wire this using spring
	
	@Autowired
	public CustomerServiceImpl(CustomerDAOImpl custDAO){
		this.custDAO=custDAO;
	}

	
	public CustomerVO isCustomerExsist(CustomerVO customer) {
		return custDAO.isCustomerExsist(customer);
	}


	public CustomerVO insertNewCustomer(CustomerDetailVO customerDetailVO) {
		return custDAO.insertNewCustomer(customerDetailVO);
	}

}
