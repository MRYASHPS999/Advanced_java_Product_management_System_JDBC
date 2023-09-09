package com.product_management_system.service;

import com.product_management_system.dao.CustomerDao;
import com.product_management_system.dto.Customer;

public class CustomerService {
	
	CustomerDao customerDao=new CustomerDao();
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public Customer getAllCustomerData(Customer customer) {
		return customerDao.getAllCustomerData(customer);
		
	}
	
	public boolean getCustomerDataById(int c_id) {
		return customerDao.getCustomerDataById(c_id);
		
	}

	public boolean updateCustomerById(int c_id) {
		return customerDao.updateCustomerById(c_id);
		
	}
	
	public boolean deleteCustomerById(int c_id) {
		return customerDao.deleteCustomerById(c_id);
		
	}
}
