package com.verizon.springAngularInt.dao;

import java.util.List;	

import com.verizon.springAngularInt.model.Customer;

public interface CustomerDao {
	public List<Customer> getCustomer();
	public Customer createCustomer(Customer cust);
	public void deleteCustomer(Customer cust);
	public Customer getById(int id); 
}
