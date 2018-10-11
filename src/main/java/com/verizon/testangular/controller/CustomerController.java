package com.verizon.testangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.testangular.dao.CustomerDao;
import com.verizon.testangular.model.Customer;


@RestController
@RequestMapping(value="/")
@CrossOrigin(origins= {"http://localhost:4200"})
public class CustomerController {

	@Autowired
	private CustomerDao cd;
	
	@RequestMapping(value="/getall", method=RequestMethod.GET)
	public List<Customer> getAllCustomers(){
		return cd.getCustomer();
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer cust) {
		return cd.createCustomer(cust);
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") int id) {
		Customer cust=cd.getById(id);
		//System.out.println(id);
		cd.deleteCustomer(cust);
	}
}
