package com.verizon.testangular.dao;

import java.util.List;

import com.verizon.testangular.model.Customer;

public interface CustomerDao {
	public List<Customer> getCustomer();
	public Customer createCustomer(Customer cust);
	public void deleteCustomer(Customer cust);
	public Customer getById(int id); 
}
