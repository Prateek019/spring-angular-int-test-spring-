package com.verizon.testangular.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.verizon.testangular.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private MongoTemplate mt;
	
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return mt.findAll(Customer.class);
	}

	@Override
	public Customer createCustomer( Customer cust) {
		// TODO Auto-generated method stub
		 mt.save(cust);
		return cust;
	}

	@Override
	public void deleteCustomer(Customer cust) {
		mt.remove(cust);
		
	}

	@Override
	public Customer getById(int id) {
		return mt.findById(id, Customer.class);
	}

}
